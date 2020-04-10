package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.MenuScreen;
import gd.rf.theoneboringmancompany.growham.screens.PlayRoomScreen;
import gd.rf.theoneboringmancompany.growham.utils.MyButton;

public class Back extends MyButton {
    private Texture background;

    public Back(final Main main, final int i) {
        super(main, "Pictures/Buttons/NonAnimation/prev.png");
        setPosition(0, main.stage.getHeight() - getHeight());

        background = new Texture("Pictures/Other/Backgrounds/all.png");

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                switch (i) {
                    case MenuScreen.NUMBER:
                        sound.play(Volume);
                        main.setScreen(new MenuScreen(main));
                        break;
                    case PlayRoomScreen.NUMBER:
                        sound.play(Volume);
                        main.setScreen(new PlayRoomScreen(main));
                        break;
                }
                dispose();
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
        super.draw(batch, parentAlpha);
    }
}
