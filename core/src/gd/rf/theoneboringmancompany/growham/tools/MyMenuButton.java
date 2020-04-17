package gd.rf.theoneboringmancompany.growham.tools;

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

    private float delta = 0f;

    private final float BUTTON_SIZE;

    public MyMenuButton(Main main, String pathToTextureAtlas){
        this.main = main;

        atlas = new TextureAtlas(Gdx.files.internal(pathToTextureAtlas));
        animation = new Animation<>(Settings.Animation.MENU_BUTTON_ANIMATION_SPEED, atlas.getRegions());
        sound = Gdx.audio.newSound(Gdx.files.internal(Settings.Path.Audio.Sounds.BUTTON));

        BUTTON_SIZE =
                (new Sprite(atlas.findRegion(Settings.ATLAS_TEXTURE_NAME)).getHeight()
                + new Sprite(atlas.findRegion(Settings.ATLAS_TEXTURE_NAME)).getWidth()) / 2;

        this.setHeight(BUTTON_SIZE);
        this.setWidth(BUTTON_SIZE);
    }

    public float getBUTTON_SIZE() {
        return BUTTON_SIZE;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        delta += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(delta, true), getX(), getY());
    }

    public void dispose(){
        //atlas.dispose();
    }

}
