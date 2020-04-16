package gd.rf.theoneboringmancompany.growham.actors.logo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.MenuScreen;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class Logo extends Actor {
    private final Main main;

    private Texture logo;
    private Sound sound;

    public Logo(final Main main){
        this.main = main;

        logo = new Texture(Settings.Path.Pictures.Images.LOGO);
        sound = Gdx.audio.newSound(Gdx.files.internal(Settings.Path.Audio.Sounds.OK));

        setPosition(0,0);
        setWidth(main.stage.getWidth());
        setHeight(main.stage.getHeight());

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(Settings.MusicAndSound.SOUND_VOLUME);
                main.setScreen(new MenuScreen(main));
                logo.dispose();
                sound.dispose();
            }
        });

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(logo, 0, 0);
        main.fontOrdinary.draw(batch, Settings.Text.WELCOME, main.stage.getWidth()/2, main.stage.getHeight()/12);
    }
}
