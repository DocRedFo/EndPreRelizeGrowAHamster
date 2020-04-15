package gd.rf.theoneboringmancompany.growham.utils;

public class AndroidDatabase implements AndroidHandler {
    private final AndroidHandler handler;

    public AndroidDatabase(AndroidHandler handler) {
        this.handler = handler;
    }

    @Override
    public void insert(String Name, int Time) {
        handler.insert(Name, Time);
    }

    @Override
    public Object[] selectToScore() {
        return handler.selectToScore();
    }

}
