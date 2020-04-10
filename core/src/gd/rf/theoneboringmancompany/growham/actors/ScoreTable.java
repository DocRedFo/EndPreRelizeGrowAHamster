package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.utils.DataBase;

public class ScoreTable extends Actor {
    private final Main main;

    private DataBase dataBase;

    private float X;
    private float Y1;
    private float Space;

    public ScoreTable(Main main){
        this.main = main;

        dataBase = new DataBase();

        X = main.stage.getWidth()/7;
        Y1 = main.stage.getHeight()/2 + main.stage.getHeight()/9;
        Space = main.stage.getHeight()/6;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        main.fontOrdinary.setColor(Color.RED);
        main.fontOrdinary.draw(batch, "1. " + dataBase.playerScore(1), X, Y1);
        main.fontOrdinary.setColor(Color.WHITE);
        main.fontOrdinary.draw(batch, "2. " + dataBase.playerScore(2), X, Y1 - Space);
        main.fontOrdinary.draw(batch, "3. " + dataBase.playerScore(3), X, Y1 - Space*2);
    }
}
