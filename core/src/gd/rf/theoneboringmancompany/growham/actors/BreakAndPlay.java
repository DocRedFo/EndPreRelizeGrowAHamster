package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.PlayRoomScreen;
import gd.rf.theoneboringmancompany.growham.utils.MyMenuButton;

public class BreakAndPlay extends MyMenuButton {
    public BreakAndPlay(final Main main) {
        super(main, "Pictures/Buttons/Animation/BreakAndPlay/sprite.atlas");
        setPosition(0,
                main.stage.getHeight()
                        - getBUTTON_SIZE()
                        + getBUTTON_SIZE()/4
                        - getBUTTON_SIZE()/3.5f
                        + getBUTTON_SIZE()/6);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Gdx.files.local("player.dat").exists()){
                    sound.play(Volume);
                    Gdx.files.local("player.dat").delete();
                    main.hamster = new Hamster(main);
                    main.setScreen(new PlayRoomScreen(main));
                }
                else {
                    Gdx.input.vibrate(20);
                }
            }
        });
    }
}
