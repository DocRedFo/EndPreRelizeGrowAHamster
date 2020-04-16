package gd.rf.theoneboringmancompany.growham.actors.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.tools.MyButton;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class Exit extends MyButton {
    public Exit(Main main) {
        super(main, Settings.Path.Pictures.Buttons.EXIT);
        setPosition(main.stage.getWidth() - getWidth(), 0);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(Settings.MusicAndSound.SOUND_VOLUME);
                dispose();
                Gdx.app.exit();
            }
        });
    }
}
