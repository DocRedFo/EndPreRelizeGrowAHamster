package gd.rf.theoneboringmancompany.growham.screens;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.actors.Back;
import gd.rf.theoneboringmancompany.growham.actors.Food;
import gd.rf.theoneboringmancompany.growham.actors.Med;
import gd.rf.theoneboringmancompany.growham.actors.Update;
import gd.rf.theoneboringmancompany.growham.utils.MyScreen;

public class MarketScreen extends MyScreen {
    public final static int NUMBER = 4;

    public MarketScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        main.stage.addActor(new Back(main, PlayRoomScreen.NUMBER));
        main.stage.addActor(new Med(main));
        main.stage.addActor(new Food(main));
        main.stage.addActor(new Update(main));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        main.backInput(PlayRoomScreen.NUMBER);
    }
}
