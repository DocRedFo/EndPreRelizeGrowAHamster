package gd.rf.theoneboringmancompany.growham.actors.score;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.tools.MyPicture;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class Who extends MyPicture {
    public Who(Main main) {
        super(main, Settings.Path.Pictures.Icons.WHO);
        setPosition(main.stage.getWidth()/6,
                    main.stage.getHeight()/2 + main.stage.getHeight()/6);
    }
}
