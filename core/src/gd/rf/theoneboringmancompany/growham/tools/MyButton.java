package gd.rf.theoneboringmancompany.growham.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

import gd.rf.theoneboringmancompany.growham.Main;

public abstract class MyButton extends Button {
    protected final Main main;

    protected Texture img;
    protected Texture imgButton;
    protected Sound sound;

    protected String howMuch;

    //Simple Button
    public MyButton(Main main, String pathToImage) {
        this.main = main;

        imgButton = new Texture(pathToImage);
        sound = Gdx.audio.newSound(Gdx.files.internal(Settings.Path.Audio.Sounds.BUTTON));

        setWidth(imgButton.getWidth());
        setHeight(imgButton.getHeight());
    }

    //Buy Button
    public MyButton(Main main, String pathToImageButton, String pathToImg, String howMuch) {
        this.main = main;

        imgButton = new Texture(pathToImageButton);
        img = new Texture(pathToImg);
        sound = Gdx.audio.newSound(Gdx.files.internal(Settings.Path.Audio.Sounds.BUTTON));

        this.howMuch = howMuch;

        setWidth(imgButton.getWidth());
        setHeight(imgButton.getHeight());
    }

    public void dispose() {
        sound.dispose();
        //img.dispose();
        //imgButton.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(imgButton, getX(), getY());
        if (!(img == null)) {
            batch.draw(img, getX() - imgButton.getWidth() * 4,
                            getY() - img.getHeight() / 3.2f);
            main.fontOrdinary.getData().setScale(2.5f);
            main.fontOrdinary.setColor(Color.WHITE);
            main.fontOrdinary.draw(batch, howMuch + " $",  main.stage.getWidth()/2 - main.stage.getWidth()/8,
                                                    getY() + imgButton.getHeight()/2.5f);
        }
    }
}

