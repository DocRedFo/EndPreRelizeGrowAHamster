package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.MyButton;

public class FitPlay extends MyButton {
    private float time = 0f;
    private boolean clicked = true;
    private boolean back = false;
    private boolean to = false;
    private boolean sit = false;

    public FitPlay(final Main main) {
        super(main, "Pictures/Buttons/NonAnimation/fitplay.png");
        setPosition(main.stage.getWidth() - imgButton.getWidth(), main.stage.getHeight() / 50);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (main.hamster.button == main.hamster.bAll && clicked){
                    main.hamster.button = main.hamster.bPlay;
                    clicked = false;
                    sit = false;
                    to = true;
                    time = 0;
                    setPosition();

                }
                else {
                    Gdx.input.vibrate(20);
                }
            }
        });
    }



    private void to(float delta){
        if (main.hamster.button == main.hamster.bPlay && to){
        if (main.hamster.getX() + main.hamster.HSize > 0){
            main.hamster.setX(main.hamster.getX() - delta);
            time = 0f;
        }
        if (main.hamster.getX() + main.hamster.HSize == 0) {
            if (time > 15) {
                for (int i = 0; i < 10 && main.hamster.getHealth() < 100; i++)
                    main.hamster.setHealth(main.hamster.getHealth() + 1);
                for (int i = 5; i > 0 && main.hamster.getHungry() > 0; i--)
                    main.hamster.setHungry(main.hamster.getHungry() - 1);
                to = false;
                back = true;
                time = 0f;
                setPosition();
            }
        }
        }
    }

    private void back(float delta){
        if (main.hamster.button == main.hamster.bPlay && back) {
            if (main.hamster.getX() < main.hamster.standardX) {
                main.hamster.setX(main.hamster.getX() + delta);
                time = 0f;
            }
            if (main.hamster.getX() == main.hamster.standardX) {
                to = false;
                back = false;
                sit = true;
                setPosition();
                sit = false;
            }
        }
    }

    private void ReClick(){
        if (time > 28 && main.hamster.button == main.hamster.bPlay && main.hamster.getX() == main.hamster.standardX) {
            clicked = true;
            main.hamster.button = main.hamster.bAll;
        }
    }

    private void setPosition(){
        if (main.hamster.button == main.hamster.bPlay) {
            if (to) {
                main.hamster.setPosition("Left");
            }
            if (back) {
                main.hamster.setPosition("Right");
            }
            if (sit) {
                main.hamster.setPosition("Sit");
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        time += Gdx.graphics.getDeltaTime();
        if (to){
            setPosition();
            to(parentAlpha);
        }
        if (back){
            setPosition();
            back(parentAlpha);
        }
        ReClick();
    }
}
