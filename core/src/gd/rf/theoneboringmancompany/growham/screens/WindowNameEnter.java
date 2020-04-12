package gd.rf.theoneboringmancompany.growham.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;


import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.actors.OK;
import gd.rf.theoneboringmancompany.growham.utils.MyScreen;

public class WindowNameEnter extends MyScreen {
    private final PlayRoomScreen playRoomScreen;
    public TextField textField;
    private OK ok;

    public WindowNameEnter(Main main, PlayRoomScreen playRoomScreen) {
        super(main);
        this.playRoomScreen = playRoomScreen;
    }

    @Override
    public void show() {
        super.show();

        ok = new OK(main, playRoomScreen, this);
        main.stage.addActor(ok);

        Skin skin = new Skin(Gdx.files.internal("Skin/skin/uiskin.json"));

        textField = new TextField("", skin);
        textField.setSize(main.stage.getWidth()/2.5f, main.stage.getHeight()/8);
        textField.setPosition(main.stage.getWidth()/2 - textField.getWidth()/2,main.stage.getHeight()/2 - textField.getHeight()/2);

        main.stage.addActor(textField);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        main.backInput(MenuScreen.NUMBER);
    }
}
