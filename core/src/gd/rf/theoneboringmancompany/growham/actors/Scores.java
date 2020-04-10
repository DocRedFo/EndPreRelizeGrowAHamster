package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.ScoreScreen;
import gd.rf.theoneboringmancompany.growham.utils.MyMenuButton;

public class Scores extends MyMenuButton {
    public Scores(final Main main) {
        super(main, "Pictures/Buttons/Animation/Scores/sprite.atlas");
        setPosition(main.stage.getWidth()
                        - getBUTTON_SIZE()
                        - getBUTTON_SIZE()/6,

                main.stage.getHeight()
                        - getBUTTON_SIZE()
                        - getBUTTON_SIZE()/8
                        + getBUTTON_SIZE()/4);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(Volume);
                main.stage.clear();
                main.setScreen(new ScoreScreen(main));
                dispose();
            }
        });

    }
}
