package gd.rf.theoneboringmancompany.growham.actors.menu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.PlayScreen;
import gd.rf.theoneboringmancompany.growham.tools.MyMenuButton;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class Play extends MyMenuButton {
    private Texture background;

    public Play(final Main main) {
        super(main, Settings.Path.TextureAtlas.PLAY_BUTTON_ATLAS);
        setPosition(main.stage.getWidth()/2
                        - getBUTTON_SIZE()/3
                        - getBUTTON_SIZE()/8,

                main.stage.getHeight()/2
                        - getBUTTON_SIZE()/4
                        - getBUTTON_SIZE()/2);

        background = new Texture(Settings.Path.Pictures.Backgrounds.MENU);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(Settings.MusicAndSound.SOUND_VOLUME);
                main.stage.clear();
                main.setScreen(new PlayScreen(main));
                dispose();
            }
        });

    }

    @Override
    public void dispose() {
        super.dispose();
        background.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(background, 0, 0);
        super.draw(batch, parentAlpha);
    }
}
