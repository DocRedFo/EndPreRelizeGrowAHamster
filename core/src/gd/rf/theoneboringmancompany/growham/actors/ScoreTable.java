package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import gd.rf.theoneboringmancompany.growham.Main;

public class ScoreTable extends Actor {
    private final Main main;

    private float X;
    private float Y1;
    private float Space;

    public ScoreTable(Main main){
        this.main = main;

        X = main.stage.getWidth()/7;
        Y1 = main.stage.getHeight()/2 + main.stage.getHeight()/9;
        Space = main.stage.getHeight()/6;
    }

    public String playerScore(int num){
        String result = "";
        Object[] o = main.database.select();

        for (int i = 0; i < 6; i++){
            if (o[i] == null) o[i] = "";
        }

        switch (num){
            case 1:
                result = o[0] + "    " + o[1];
                break;
            case 2:
                result = o[2] + "    " + o[3];
                break;
            case 3:
                result = o[4] + "    " + o[5];
                break;
        }

        return result;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        main.fontOrdinary.setColor(Color.RED);
        main.fontOrdinary.draw(batch, "1. " + playerScore(1), X, Y1);
        main.fontOrdinary.setColor(Color.WHITE);
        main.fontOrdinary.draw(batch, "2. " + playerScore(2), X, Y1 - Space);
        main.fontOrdinary.draw(batch, "3. " + playerScore(3), X, Y1 - Space*2);
    }
}
