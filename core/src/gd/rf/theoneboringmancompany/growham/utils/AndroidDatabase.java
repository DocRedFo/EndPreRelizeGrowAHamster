package gd.rf.theoneboringmancompany.growham.utils;

public class AndroidDatabase implements AndroidHandler {
    private final AndroidHandler handler;

    public AndroidDatabase(AndroidHandler handler) {
        this.handler = handler;
    }

    @Override
    public long insert(String Name, int Time) {
        return handler.insert(Name, Time);
    }

    @Override
    public Object[] select() {
        return handler.select();
    }
}
