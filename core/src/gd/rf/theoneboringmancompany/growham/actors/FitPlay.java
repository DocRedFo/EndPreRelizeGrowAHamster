package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.MyButton;

public class FitPlay extends MyButton {
    public FitPlay(final Main main) {
        super(main, "Pictures/Buttons/NonAnimation/fitplay.png");
        setPosition(main.stage.getWidth() - imgButton.getWidth(), main.stage.getHeight() / 50);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (main.hamster.buttonNum == main.hamster.AnythingButton){
                    main.hamster.buttonNum = main.hamster.PlayButton;
                    main.hamster.FitPlay();
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
