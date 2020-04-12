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
    private boolean sit = true;

    public FitPlay(final Main main) {
        super(main, "Pictures/Buttons/NonAnimation/fitplay.png");
        setPosition(main.stage.getWidth() - imgButton.getWidth(), main.stage.getHeight() / 50);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (clicked){
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
        if (main.hamster.getX() + main.hamster.atlas.createSprite("file").getWidth() > 0){
            main.hamster.setX(main.hamster.getX() - delta);
            time = 0f;
        }
        if (main.hamster.getX() + main.hamster.atlas.createSprite("file").getWidth() == 0){
            if (time > 15){
                for (int i = 0; i < 10 && main.hamster.getHealth() < 100; i++)main.hamster.setHealth(main.hamster.getHealth() + 1);
                for (int i = 5; i > 0 && main.hamster.getHungry() > 0; i--)main.hamster.setHungry(main.hamster.getHungry() - 1);
                to = false;
                back = true;
                time = 0f;
                setPosition();
            }
        }
    }

    private void back(float delta){
        if (main.hamster.getX()  < main.hamster.standardX){
            main.hamster.setX(main.hamster.getX() + delta);
        }
        if (main.hamster.getX() == main.hamster.standardX || time >= 12){
                to = false;
                back = false;
                sit = true;
                time = 0f;
                setPosition();
                sit = false;
                if (time > 28){
                    clicked = true;
                }
        }
    }

    private void setPosition(){
        if (to){
            main.hamster.setPosition("Left");
        }
        if (back){
            main.hamster.setPosition("Right");
        }
        if (sit){
            main.hamster.setPosition("Sit");
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
        setPosition();
    }
}
