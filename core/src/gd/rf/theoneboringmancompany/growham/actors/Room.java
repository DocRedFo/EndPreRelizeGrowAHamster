package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.MyPicture;

public class Room extends MyPicture {
    private Texture tube;

    public Room(Main main) {
        super(main, "Pictures/Other/Room/room.png");
        setPosition(0, 0);
        if (main.hamster.getRoomLevel() >= 2) {
            tube = new Texture("Pictures/Other/Room/tube.png");
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (main.hamster.getRoomLevel() >= 2) {
            batch.draw(tube, main.stage.getWidth() / 2 + main.stage.getWidth() / 5,
                    main.stage.getHeight() / 2 - main.stage.getWidth() / 5.3f);
        }
    }
}