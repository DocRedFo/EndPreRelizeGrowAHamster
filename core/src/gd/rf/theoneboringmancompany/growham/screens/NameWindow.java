package gd.rf.theoneboringmancompany.growham.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;


import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.actors.name.OK;
import gd.rf.theoneboringmancompany.growham.tools.MyScreen;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class NameWindow extends MyScreen {
    private final PlayScreen playScreen;
    public TextField textField;
    private OK ok;

    public NameWindow(Main main, PlayScreen playScreen) {
        super(main);
        this.playScreen = playScreen;
    }

    @Override
    public void show() {
        super.show();

        ok = new OK(main, playScreen, this);
        main.stage.addActor(ok);

        Skin skin = new Skin(Gdx.files.internal(Settings.Path.UI_SKIN_TEXT_FIELD));

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
