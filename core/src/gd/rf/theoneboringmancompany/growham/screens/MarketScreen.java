package gd.rf.theoneboringmancompany.growham.screens;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.actors.Back;
import gd.rf.theoneboringmancompany.growham.actors.market.Food;
import gd.rf.theoneboringmancompany.growham.actors.market.Med;
import gd.rf.theoneboringmancompany.growham.actors.market.Upgrade;
import gd.rf.theoneboringmancompany.growham.tools.MyScreen;

public class MarketScreen extends MyScreen {
    public final static int NUMBER = 4;

    public MarketScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        main.stage.addActor(new Back(main, PlayScreen.NUMBER));
        main.stage.addActor(new Med(main));
        main.stage.addActor(new Food(main));
        main.stage.addActor(new Upgrade(main));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        main.backInput(PlayScreen.NUMBER);
    }
}
