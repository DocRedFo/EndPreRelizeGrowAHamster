package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.MyButton;

public class Sleep extends MyButton {
    private float time = 0f;
    private boolean clicked = true;

    public Sleep(final Main main) {
        super(main, "Pictures/Buttons/NonAnimation/sleep.png");
        setPosition(main.stage.getWidth() - imgButton.getWidth(),
                imgButton.getHeight() + main.stage.getHeight()/18);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (main.hamster.button == main.hamster.bAll && clicked) {
                    main.hamster.button = main.hamster.bSleep;
                    clicked = false;
                    time = 0f;
                    main.hamster.setPosition("Sleep");
                    if (main.hamster.getHealth() < 100)main.hamster.setHealth(main.hamster.getHealth() + 1);
                    if (main.hamster.getHungry() < 100)main.hamster.setHungry(main.hamster.getHungry() + 1);
                }
                else {
                    Gdx.input.vibrate(20);
                }
            }
        });
    }



    private void setOutSleep(){
        if (main.hamster.button == main.hamster.bSleep && time > 20){
            main.hamster.setPosition("Sit");
            main.hamster.button = main.hamster.bAll;
        }
    }

    private void Sleep(){
        if (time > 100){
            time = 0;
            clicked = true;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        time+= Gdx.graphics.getDeltaTime();
        setOutSleep();
        Sleep();
    }
}
