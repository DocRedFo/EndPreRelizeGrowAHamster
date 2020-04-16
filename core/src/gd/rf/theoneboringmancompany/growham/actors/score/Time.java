package gd.rf.theoneboringmancompany.growham.actors.score;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.tools.MyPicture;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class Time extends MyPicture {
    public Time(Main main) {
        super(main, Settings.Path.Pictures.Icons.TIME);
        setPosition(main.stage.getWidth()/2,
                    main.stage.getHeight()/2 + main.stage.getHeight()/6);
    }
}
