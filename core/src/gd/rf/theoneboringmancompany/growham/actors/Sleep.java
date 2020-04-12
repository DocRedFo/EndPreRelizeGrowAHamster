package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.MyButton;

public class Sleep extends MyButton {
    public Sleep(final Main main) {
        super(main, "Pictures/Buttons/NonAnimation/sleep.png");
        setPosition(main.stage.getWidth() - imgButton.getWidth(),
                    imgButton.getHeight() + main.stage.getHeight()/18);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (main.hamster.buttonNum == main.hamster.AnythingButton) {
                    main.hamster.buttonNum = main.hamster.SleepButton;
                    main.hamster.Sleep();
                }
                else {
                    Gdx.input.vibrate(20);
                }
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
