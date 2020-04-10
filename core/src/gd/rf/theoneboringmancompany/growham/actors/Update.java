package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.MyButton;

public class Update extends MyButton {
    public Update(Main main) {
        super(main, "Pictures/Buttons/NonAnimation/upgrade.png",
                "Pictures/Other/updateRoom.png",
                "1000");
        setPosition(main.stage.getWidth() - imgButton.getWidth() * 1.5f,
                main.stage.getHeight() / 2 - main.stage.getHeight() / 2.5f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (main.hamster.getRoomLevel() < 2) {
            batch.draw(imgButton, getX(), getY());
            batch.draw(img, getX() - imgButton.getWidth() * 4,
                    getY() - img.getHeight() / 3.2f);
            main.fontOrdinary.getData().setScale(2.5f);
            main.fontOrdinary.draw(batch, howMuch, main.stage.getWidth() / 2 - main.stage.getWidth() / 8,
                    getY() + imgButton.getHeight() / 1.5f);
        }

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (main.hamster.getRoomLevel() == 1 && main.hamster.getMoney() >= Integer.parseInt(howMuch)){
                    sound.play(Volume);
                    main.hamster.setRoomLevel(main.hamster.getRoomLevel()+1);
                    main.hamster.setMoney(main.hamster.getMoney() - Integer.parseInt(howMuch));

                    if (main.hamster.getHealth() != 100)main.hamster.setHealth(main.hamster.getHealth()+1);
                }
                else {
                    Gdx.input.vibrate(20);
                }

            }
        });

    }
}
