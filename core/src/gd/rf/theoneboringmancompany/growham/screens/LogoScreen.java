package gd.rf.theoneboringmancompany.growham.screens;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.actors.Logo;
import gd.rf.theoneboringmancompany.growham.utils.MyScreen;

public class LogoScreen extends MyScreen {
    public static final int NUMBER = 0;

    public LogoScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        super.show();
        main.stage.addActor(new Logo(main));
    }
}
