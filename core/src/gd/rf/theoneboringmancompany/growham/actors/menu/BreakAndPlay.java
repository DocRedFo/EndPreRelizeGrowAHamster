package gd.rf.theoneboringmancompany.growham.actors.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.actors.play.Hamster;
import gd.rf.theoneboringmancompany.growham.screens.PlayScreen;
import gd.rf.theoneboringmancompany.growham.tools.MyMenuButton;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class BreakAndPlay extends MyMenuButton {
    public BreakAndPlay(final Main main) {
        super(main, Settings.Path.TextureAtlas.BREAK_AND_PLAY_BUTTON_ATLAS);
        setPosition(0,
                main.stage.getHeight()
                        - getBUTTON_SIZE()
                        + getBUTTON_SIZE()/4
                        - getBUTTON_SIZE()/3.5f
                        + getBUTTON_SIZE()/6);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Gdx.files.local(Settings.Path.SERIALIZATION_FILE).exists()){
                    sound.play(Settings.MusicAndSound.SOUND_VOLUME);
                    Gdx.files.local(Settings.Path.SERIALIZATION_FILE).delete();
                    main.hamster = new Hamster(main);
                    main.setScreen(new PlayScreen(main));
                }
                else {
                    Gdx.input.vibrate(20);
                }
            }
        });
    }
}
