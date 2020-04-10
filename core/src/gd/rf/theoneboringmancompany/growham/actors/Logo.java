package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.MenuScreen;

public class Logo extends Actor {
    private final Main main;

    private Texture logo;
    private Sound sound;

    private final String pathToSound = "Audio/UI/ok.mp3";
    private final float Volume = 30/100f;


    private final String text = "Нажмите для начала";

    public Logo(final Main main){
        this.main = main;

        logo = new Texture("Pictures/Other/logo.png");
        sound = Gdx.audio.newSound(Gdx.files.internal(pathToSound));

        setPosition(0,0);
        setWidth(main.stage.getWidth());
        setHeight(main.stage.getHeight());

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(Volume);
                main.setScreen(new MenuScreen(main));
                logo.dispose();
                sound.dispose();
            }
        });

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(logo, 0, 0);
        main.fontOrdinary.draw(batch, text, main.stage.getWidth()/2, main.stage.getHeight()/12);
    }
}
