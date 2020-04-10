package gd.rf.theoneboringmancompany.growham.actors;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.MyPicture;

public class Who extends MyPicture {
    public Who(Main main) {
        super(main, "Pictures/Other/Scores/who.png");
        setPosition(main.stage.getWidth()/6,
                    main.stage.getHeight()/2 + main.stage.getHeight()/6);
    }
}
