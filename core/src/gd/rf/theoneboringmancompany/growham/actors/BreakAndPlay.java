package gd.rf.theoneboringmancompany.growham.actors;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.MyMenuButton;

public class BreakAndPlay extends MyMenuButton {
    public BreakAndPlay(Main main) {
        super(main, "Pictures/Buttons/Animation/BreakAndPlay/sprite.atlas");
        setPosition(0,
                main.stage.getHeight()
                        - getBUTTON_SIZE()
                        + getBUTTON_SIZE()/4
                        - getBUTTON_SIZE()/3.5f
                        + getBUTTON_SIZE()/6);
    }
}
