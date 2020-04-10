package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import gd.rf.theoneboringmancompany.growham.Main;

public class Information extends Table {
    private final Main main;
    private final Hamster hamster;

    private Label aboutHealth;
    private Label health;
    private Label aboutHungry;
    private Label hungry;
    private Label aboutAge;
    private Label age;
    private Label aboutMoney;
    private Label money;

    public Information(Main main) {
        this.main = main;
        this.hamster = main.hamster;

        this.top();
        this.setFillParent(true);

        aboutHealth = new Label("Здоровье", new Label.LabelStyle(main.fontOrdinary, Color.WHITE));
        aboutHungry = new Label("Голод", new Label.LabelStyle(main.fontOrdinary, Color.WHITE));
        aboutAge = new Label("Возраст", new Label.LabelStyle(main.fontOrdinary, Color.WHITE));
        aboutMoney = new Label("Деньги", new Label.LabelStyle(main.fontOrdinary, Color.WHITE));

        setInfo();

        this.add(aboutHealth).expandX().padTop(10);
        this.add(aboutHungry).expandX().padTop(10);
        this.add(aboutAge).expandX().padTop(10);
        this.add(aboutMoney).expandX().padTop(10);
        this.row();
        this.add(health);
        this.add(hungry);
        this.add(age);
        this.add(money);

        setPosition(0, 0);
        setHeight(main.stage.getHeight());
        setWidth(main.stage.getWidth());
    }

    public void setInfo(){
        Color CHealth = Color.WHITE;
        Color CHungry = Color.WHITE;

        if (hamster.getHealth() <= 10){
            CHealth = Color.RED;
        }
        if (hamster.getHungry() <= 10){
            CHungry = Color.RED;
        }

        health = new Label(Integer.toString(hamster.getHealth()), new Label.LabelStyle(main.fontOrdinary, CHealth));
        hungry = new Label(Integer.toString(hamster.getHungry()), new Label.LabelStyle(main.fontOrdinary, CHungry));
        age = new Label(Integer.toString(hamster.getAge()), new Label.LabelStyle(main.fontOrdinary, Color.WHITE));
        money = new Label(Integer.toString(hamster.getMoney()), new Label.LabelStyle(main.fontOrdinary, Color.WHITE));
    }

    public void updateInfo(){
        hamster.setHealth(hamster.getHealth() - 1);
        hamster.setHungry(hamster.getHungry() - 1);

        Color CHealth = Color.WHITE;
        Color CHungry = Color.WHITE;

        if (hamster.getHealth() <= 10){
            CHealth = Color.RED;
        }
        if (hamster.getHungry() <= 10){
            CHungry = Color.RED;
        }

        health.setText(Integer.toString(hamster.getHealth()));
        hungry.setText(Integer.toString(hamster.getHungry()));
        health.setColor(CHealth);
        hungry.setColor(CHungry);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        main.fontOrdinary.getData().setScale(1.2f);
        updateInfo();
        super.draw(batch, parentAlpha);
    }
}
