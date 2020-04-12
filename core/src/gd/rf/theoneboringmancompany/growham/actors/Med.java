package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.MyButton;

public class Med extends MyButton {
    public Med(final Main main) {
        super(main, "Pictures/Buttons/NonAnimation/buy.png",
                    "Pictures/Other/med.png", "50");
        setPosition(main.stage.getWidth() - imgButton.getWidth()*1.5f,
                    main.stage.getHeight()/2 + main.stage.getHeight()/6);
        sound = Gdx.audio.newSound(Gdx.files.internal("Audio/UI/health.mp3"));

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (main.hamster.getHealth() < 100 && main.hamster.getMoney() >= Integer.parseInt(howMuch)){
                    sound.play(Volume);
                    main.hamster.setMoney(main.hamster.getMoney() - Integer.parseInt(howMuch));
                    for (int i = 0; i < 10 && main.hamster.getHealth() < 100; i++){
                        main.hamster.setHealth(main.hamster.getHealth() + 10);
                    }
                }
                else {
                    Gdx.input.vibrate(20);
                }
            }
        });
    }
}
