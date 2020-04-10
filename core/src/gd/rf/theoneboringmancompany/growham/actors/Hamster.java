package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;

import gd.rf.theoneboringmancompany.growham.Main;

public class Hamster extends Actor {
    private final Main main;

    protected String name;

    private boolean hasNamed = false;

    private int age = 0;
    private int health = 100;
    private int hungry = 100;
    private int money = 2001;
    private int roomLevel = 1;

    private TextureAtlas atlas;
    private Animation animation;

    private float animationTime = 0f;

    public Hamster(Main main){
        this.main = main;
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
