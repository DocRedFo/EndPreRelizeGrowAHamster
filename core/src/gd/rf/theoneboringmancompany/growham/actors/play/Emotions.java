package gd.rf.theoneboringmancompany.growham.actors.play;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class Emotions extends Actor {
    private final Hamster hamster;

    private Texture bad;
    private Texture good;
    private Texture norm;

    private Texture emotion;

    public Emotions(Main main) {
        this.hamster = main.hamster;

        good = new Texture(Settings.Path.Pictures.Emotions.GOOD);
        norm = new Texture(Settings.Path.Pictures.Emotions.NORMAL);
        bad = new Texture(Settings.Path.Pictures.Emotions.BAD);

        setEmotion();

        setPosition(0,0);
    }

    private void setEmotion(){
        int l = (hamster.getHungry() + hamster.getHealth()) / 2;
        if (l >= 75){
            emotion = good;
        }
        if (l < 75 && l > 50){
            emotion = norm;
        }
        if (l <= 50){
            emotion = bad;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(emotion, 0, 0);
        setEmotion();
    }
}
