package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.MyButton;

public class Exit extends MyButton {
    public Exit(Main main) {
        super(main, "Pictures/Buttons/NonAnimation/exit.png");
        setPosition(main.stage.getWidth() - getWidth(), 0);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(Volume);
                dispose();
                Gdx.app.exit();
            }
        });
    }
}
