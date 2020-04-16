package gd.rf.theoneboringmancompany.growham.actors.name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.PlayScreen;
import gd.rf.theoneboringmancompany.growham.screens.NameWindow;
import gd.rf.theoneboringmancompany.growham.tools.MyButton;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class OK extends MyButton {
    private Texture background;

    public OK(final Main main, final PlayScreen playScreen, final NameWindow nameWindow) {
        super(main, Settings.Path.Pictures.Buttons.OK);
        setPosition(main.stage.getWidth()/2 + main.stage.getWidth()/4, main.stage.getHeight()/2 - imgButton.getHeight()/2f);

        sound = Gdx.audio.newSound(Gdx.files.internal(Settings.Path.Audio.Sounds.OK));
        background = new Texture(Settings.Path.Pictures.Backgrounds.ALL);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!nameWindow.textField.getText().equals("")){
                sound.play(Settings.MusicAndSound.SOUND_VOLUME);
                main.hamster.setName(nameWindow.textField.getText());
                main.hamster.setHasNamed(true);
                main.setScreen(playScreen);
                main.fontOrdinary.getData().setScale(2.5f);
                dispose();
                }
                else {
                    Gdx.input.vibrate(20);
                }
            }
        });

    }

    @Override
    public void dispose() {
        super.dispose();
        //background.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(background, 0, 0);
        main.fontOrdinary.getData().setScale(1.2f);
        main.fontOrdinary.draw(batch, Settings.Text.ENTER_NAME, getX()/2.25f, main.stage.getHeight()/2f +main.stage.getHeight()/5f);
        super.draw(batch, parentAlpha);
    }
}
