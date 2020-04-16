package gd.rf.theoneboringmancompany.growham.actors.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.ScoreScreen;
import gd.rf.theoneboringmancompany.growham.tools.MyMenuButton;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class Scores extends MyMenuButton {
    public Scores(final Main main) {
        super(main, Settings.Path.TextureAtlas.SCORES_BUTTON_ATLAS);
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
                sound.play(Settings.MusicAndSound.SOUND_VOLUME);
                main.stage.clear();
                main.setScreen(new ScoreScreen(main));
                dispose();
            }
        });

    }
}
