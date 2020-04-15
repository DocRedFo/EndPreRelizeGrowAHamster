package gd.rf.theoneboringmancompany.growham;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import gd.rf.theoneboringmancompany.growham.utils.AndroidHandler;

public class DataBase implements AndroidHandler {

    private static final String DATABASE_NAME = "scores.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "scoreTable";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_TIME = "Time";

    private static final int NUM_COLUMN_ID = 0;
    private static final int NUM_COLUMN_NAME = 0;
    private static final int NUM_COLUMN_TIME = 1;

    private SQLiteDatabase mDataBase;
    private OpenHelper openHelper;

    public DataBase(Context context) {
        openHelper = new OpenHelper(context);
    }

    public void insert(String Name, int Time) {
        mDataBase = openHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, Name);
        cv.put(COLUMN_TIME, Time);

        mDataBase.insert(TABLE_NAME, null, cv);

        openHelper.close();
        mDataBase.close();
    }



    public Object[] selectToScore() {
        mDataBase = openHelper.getReadableDatabase();

        String[] columns = {COLUMN_NAME, COLUMN_TIME};
        Object[] o = new Object[6];

        Cursor mCursor = mDataBase.query(TABLE_NAME, columns, null, null,
                null, null , COLUMN_TIME + " DESC", String.valueOf(3));

        int oNum = 0;

        if (mCursor.moveToFirst()) {
            int count = mCursor.getCount();
                for (int i = 0; i < 3 && i < count; i++) {
                    String Name = mCursor.getString(NUM_COLUMN_NAME);
                    o[oNum] = Name;
                    oNum++;

                    int Time = mCursor.getInt(NUM_COLUMN_TIME);
                    o[oNum] = Time;
                    oNum++;

                    mCursor.moveToNext();
                }

        }

        mCursor.close();
        openHelper.close();
        mDataBase.close();

        return o;

    }


    private static class OpenHelper extends SQLiteOpenHelper {

        OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT,"+
                    COLUMN_TIME +" INT);";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

}