package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.MarketScreen;
import gd.rf.theoneboringmancompany.growham.utils.MyButton;

public class Market extends MyButton {
    public Market(final Main main) {
        super(main, "Pictures/Buttons/NonAnimation/market.png");
        setPosition(main.stage.getWidth() - getWidth(), main.stage.getHeight() - getHeight());

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.stage.clear();
                sound.play(Volume);
                main.setScreen(new MarketScreen(main));
                dispose();
            }
        });
    }
}
