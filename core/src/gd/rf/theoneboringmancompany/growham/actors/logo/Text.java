package gd.rf.theoneboringmancompany.growham.actors.logo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.MenuScreen;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class Text extends Actor {
    private final Main main;

    private float time;
    private Label text;

    private boolean colorWhite = true;

    public Text(final Main main) {
        this.main = main;

        text = new Label(Settings.Text.WELCOME, new Label.LabelStyle(main.fontOrdinary, Color.WHITE));
        text.setPosition(main.stage.getWidth()/2, main.stage.getHeight()/12);
        setHeight(main.stage.getHeight());
        setWidth(main.stage.getWidth());
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new MenuScreen(main));
            }
        });
    }

    public void setColor(){
        if (time>=1.25){
            time = 0;
            if (colorWhite){
                text.setColor(1,1,1,175/255f);
                colorWhite = false;
            }
            else {
                text.setColor(1,1,1, 1);
                colorWhite = true;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        time += Gdx.graphics.getDeltaTime();
        text.draw(batch, parentAlpha);
        setColor();
    }
}
