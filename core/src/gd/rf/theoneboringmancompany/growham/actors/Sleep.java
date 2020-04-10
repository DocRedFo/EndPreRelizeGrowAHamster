package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.MyButton;

public class Sleep extends MyButton {
    public Sleep(Main main) {
        super(main, "Pictures/Buttons/NonAnimation/sleep.png");
        setPosition(main.stage.getWidth() - imgButton.getWidth(),
                    imgButton.getHeight() + main.stage.getHeight()/18);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
    }
}
