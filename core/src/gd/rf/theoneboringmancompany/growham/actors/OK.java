package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.PlayRoomScreen;
import gd.rf.theoneboringmancompany.growham.utils.MyButton;

public class OK extends MyButton {
    private String hiText ="Введите имя Вашего питомца";

    public OK(final Main main, final PlayRoomScreen playRoomScreen, final WindowNameEnter windowNameEnter) {
        super(main, "Pictures/Buttons/NonAnimation/ok.png");
        setPosition(main.stage.getWidth()/2 + main.stage.getWidth()/4, main.stage.getHeight()/7);

        sound = Gdx.audio.newSound(Gdx.files.internal("Audio/UI/ok.mp3"));

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!windowNameEnter.textField.getText().equals("")){
                sound.play(Volume);
                main.hamster.setName(windowNameEnter.textField.getText());
                main.hamster.setHasNamed(true);
                main.setScreen(playRoomScreen);
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
        main.fontOrdinary.getData().setScale(1.2f);
        main.fontOrdinary.draw(batch, hiText, getX()/2.5f, main.stage.getHeight()/2f +main.stage.getHeight()/8f);
        super.draw(batch, parentAlpha);
    }
}