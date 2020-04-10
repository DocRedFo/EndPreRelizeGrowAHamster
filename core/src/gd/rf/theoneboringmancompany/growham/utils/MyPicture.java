package gd.rf.theoneboringmancompany.growham.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import gd.rf.theoneboringmancompany.growham.Main;

public abstract class MyPicture extends Actor {
    protected Main main;

    private Texture img;

    public MyPicture(Main main, String pathToPicture){
        this.main = main;

        img = new Texture(pathToPicture);

        setWidth(img.getWidth());
        setHeight(img.getHeight());
    }

    public void dispose(){
        img.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(img, getX(), getY());
    }
}
