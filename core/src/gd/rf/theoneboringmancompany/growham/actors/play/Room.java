package gd.rf.theoneboringmancompany.growham.actors.play;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.tools.MyPicture;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class Room extends MyPicture {
    private Texture tube;

    public Room(Main main) {
        super(main, Settings.Path.Pictures.Backgrounds.ROOM);
        setPosition(0, 0);
        if (main.hamster.getRoomLevel() >= 2) {
            tube = new Texture(Settings.Path.Pictures.Images.TUBE);
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