package gd.rf.theoneboringmancompany.growham.actors.play;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.MarketScreen;
import gd.rf.theoneboringmancompany.growham.tools.MyButton;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class Market extends MyButton {
    public Market(final Main main) {
        super(main, Settings.Path.Pictures.Buttons.MARKET);
        setPosition(main.stage.getWidth() - getWidth(), main.stage.getHeight() - getHeight());

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.stage.clear();
                sound.play(Settings.MusicAndSound.SOUND_VOLUME);
                main.setScreen(new MarketScreen(main));
                dispose();
            }
        });
    }
}
