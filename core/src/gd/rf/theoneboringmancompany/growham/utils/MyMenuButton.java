package gd.rf.theoneboringmancompany.growham.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

import gd.rf.theoneboringmancompany.growham.Main;

public abstract class MyMenuButton extends Button {
    private final Main main;

    protected Sound sound;

    private TextureAtlas atlas;
    private Animation<TextureAtlas.AtlasRegion> animation;

    private float AnimationSpeed = 1/45f;
    private float time = 0f;
    protected final float Volume = 30/100f;

    private final float BUTTON_SIZE;

    public MyMenuButton(Main main, String pathToTextureAtlas){
        this.main = main;

        atlas = new TextureAtlas(Gdx.files.internal(pathToTextureAtlas));
        animation = new Animation<>(AnimationSpeed, atlas.getRegions());
        sound = Gdx.audio.newSound(Gdx.files.internal("Audio/UI/button.mp3"));

        BUTTON_SIZE =
                (new Sprite(atlas.findRegion("file")).getHeight()
                + new Sprite(atlas.findRegion("file")).getWidth()) / 2;

        this.setHeight(BUTTON_SIZE);
        this.setWidth(BUTTON_SIZE);
    }

    public float getBUTTON_SIZE() {
        return BUTTON_SIZE;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        time += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(time, true), getX(), getY());
    }

    public void dispose(){
        atlas.dispose();
    }

}
