package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;

import gd.rf.theoneboringmancompany.growham.Main;

public class Hamster extends Actor {
    private final Main main;

    protected String name;

    private boolean hasNamed = false;

    private int age = 1;
    private int health = 100;
    private int hungry = 100;
    private int money = 10000;
    private int roomLevel = 1;

    private float time = 0f;
    private float ageTime = 0f;

    private TextureAtlas atlas;
    private Animation animation;

    private float animationTime = 0f;

    public Hamster(Main main){
        this.main = main;
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        ageTime += Gdx.graphics.getDeltaTime();
        time += Gdx.graphics.getDeltaTime();
        liveInformation();

    }

    public void liveInformation(){
        if (ageTime >= 3600){
            ageTime += 0;
            age += 1;
        }
        if (time >= 10) {
            time = 0;
            int i = (int) (Math.random() * 1000);
            switch (i) {
                case 4:
                    setHealth(getHealth() - 1);
                    break;
                case 88:
                    setHungry(getHungry() - 1);
                    break;
            }
        }
    }

    public boolean isHasNamed() {
        return hasNamed;
    }

    int getHealth() {
        return health;
    }

    int getAge() {
        return age;
    }

    int getMoney() {
        return money;
    }

    int getHungry() {
        return hungry;
    }

    int getRoomLevel() {
        return roomLevel;
    }

    void setHealth(int health) {
        this.health = health;
    }

    void setHungry(int hungry) {
        this.hungry = hungry;
    }

    void setMoney(int money) {
        this.money = money;
    }

    void setRoomLevel(int roomLevel) {
        this.roomLevel = roomLevel;
    }

    public void setHasNamed(boolean hasNamed) {
        this.hasNamed = hasNamed;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
