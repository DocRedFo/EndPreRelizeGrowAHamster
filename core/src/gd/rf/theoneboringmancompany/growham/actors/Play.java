package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.PlayRoomScreen;
import gd.rf.theoneboringmancompany.growham.utils.MyMenuButton;

public class Play extends MyMenuButton {
    private Texture background;

    public Play(final Main main) {
        super(main, "Pictures/Buttons/Animation/Play/sprite.atlas");
        setPosition(main.stage.getWidth()/2
                        - getBUTTON_SIZE()/3
                        - getBUTTON_SIZE()/8,

                main.stage.getHeight()/2
                        - getBUTTON_SIZE()/4
                        - getBUTTON_SIZE()/2);

        background = new Texture("Pictures/Other/Backgrounds/menu.png");

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound.play(Volume);
                main.stage.clear();
                main.setScreen(new PlayRoomScreen(main));
                dispose();
            }
        });

    }

    @Override
    public void dispose() {
        super.dispose();
        background.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(background, 0, 0);
        super.draw(batch, parentAlpha);
    }
}
