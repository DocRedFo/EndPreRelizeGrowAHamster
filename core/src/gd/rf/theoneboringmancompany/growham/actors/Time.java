package gd.rf.theoneboringmancompany.growham.actors;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.MyPicture;

public class Time extends MyPicture {
    public Time(Main main) {
        super(main, "Pictures/Other/Scores/time.png");
        setPosition(main.stage.getWidth()/2,
                    main.stage.getHeight()/2 + main.stage.getHeight()/6);
    }
}
