package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import gd.rf.theoneboringmancompany.growham.Main;

public class Emotions extends Actor {
    private final Main main;
    private final Hamster hamster;

    private Texture bad;
    private Texture good;
    private Texture norm;

    private Texture emotion;

    public Emotions(Main main) {
        this.main = main;
        this.hamster = main.hamster;

        good = new Texture("Pictures/Other/Emotions/2.png");
        norm = new Texture("Pictures/Other/Emotions/1.png");
        bad = new Texture("Pictures/Other/Emotions/0.png");

        setEmotion();

        setPosition(0,0);
    }

    public void setEmotion(){
        int l = hamster.getHungry() + hamster.getHealth();
        if (l/ 2 >= 75){
            emotion = good;
        }
        if (l/2 < 75 && l/2 > 50){
            emotion = norm;
        }
        if (l/2 <= 50){
            emotion = bad;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(emotion, 0, 0);
        setEmotion();
    }
}
