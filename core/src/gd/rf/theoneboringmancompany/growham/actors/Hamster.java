package gd.rf.theoneboringmancompany.growham.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.io.Serializable;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.ScoreScreen;

public class Hamster extends Actor implements Serializable {
    private transient Main main;

    protected String name;

    public int gameTime = 0;
    private boolean hasNamed = false;

    private int age = 1;
    private int health = 100;
    private int hungry = 100;
    private int money = 100;
    private int roomLevel = 1;

    private float time = 0f;
    private float ageTime = 0f;
    private float delta = 0f;

    final int bPlay = 2;
    final int bAll = 0;
    final int bSleep = 1;
    int button = 0;

    float HSize = 342;

    public transient TextureAtlas atlas;
    private transient Texture texture;
    private transient Animation<TextureAtlas.AtlasRegion> animation;

    private float animationTime = 1/65f;

    public final float standardX;
    public final float standardY;

    private float X;
    private float Y;
    private String position;

    private transient TextureAtlas smallSit;
    private transient TextureAtlas smallLeft;
    private transient TextureAtlas smallRight;
    private transient Texture smallSleep;

    private transient TextureAtlas NormalSit;
    private transient TextureAtlas NormalLeft;
    private transient TextureAtlas NormalRight;
    private transient Texture NormalSleep;

    private transient TextureAtlas OldSit;
    private transient TextureAtlas OldLeft;
    private transient TextureAtlas OldRight;
    private transient Texture OldSleep;

    public Hamster(Main main){
        this.main = main;

        standardX = main.stage.getWidth()/2.5f;
        standardY = main.stage.getHeight()/21;

        position = "Sit";
        X = standardX;
        Y = standardY;
        setPosition(X, Y);

        loadTextures(main);
    }

    public void loadTextures(Main main){
        main = main;

        smallSleep = new Texture("Pictures/Hamster/Sleep/Small/sleep.png");
        NormalSleep = new Texture("Pictures/Hamster/Sleep/Normal/sleep.png");
        OldSleep = new Texture("Pictures/Hamster/Sleep/Old/sleep.png");

        smallSit = new TextureAtlas("Pictures/Hamster/Sit/Small/sprite.atlas");
        NormalSit = new TextureAtlas("Pictures/Hamster/Sit/Normal/sprite.atlas");
        OldSit = new TextureAtlas("Pictures/Hamster/Sit/Old/sprite.atlas");

        smallRight = new TextureAtlas("Pictures/Hamster/Right/Small/sprite.atlas");
        NormalRight = new TextureAtlas("Pictures/Hamster/Right/Normal/sprite.atlas");
        OldRight = new TextureAtlas("Pictures/Hamster/Right/Old/sprite.atlas");

        smallLeft = new TextureAtlas("Pictures/Hamster/Left/Small/sprite.atlas");
        NormalLeft = new TextureAtlas("Pictures/Hamster/Left/Normal/sprite.atlas");
        OldLeft = new TextureAtlas("Pictures/Hamster/Left/Old/sprite.atlas");

        hamsterUpdate();

        animation = new Animation<>(animationTime, atlas.getRegions());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        delta += Gdx.graphics.getDeltaTime();
        ageTime += Gdx.graphics.getDeltaTime();
        time += Gdx.graphics.getDeltaTime();

        liveInformation();
        hamsterUpdate();



        if (position.equals("Sleep")) {
            batch.draw(texture, X, Y);
        }
        else {
            batch.draw(animation.getKeyFrame(delta, true), X, Y);
        }

        setPosition(X, Y);
    }



    public void hamsterUpdate() {
        if (age < 200) {
            switch (position) {
                case "Sit":
                    atlas = smallSit;
                    break;
                case "Right":
                    atlas = smallRight;
                    break;
                case "Left":
                    atlas = smallLeft;
                    break;
                case "Sleep":
                    texture = smallSleep;
                    break;
            }
        } else if (age > 200 && age < 800) {
            switch (position) {
                case "Sit":
                    atlas = NormalSit;
                    break;
                case "Right":
                    atlas = NormalRight;
                    break;
                case "Left":
                    atlas = NormalLeft;
                    break;
                case "Sleep":
                    texture = NormalSleep;
                    break;
            }
        } else if (age > 800 && age < 1095) {
            switch (position) {
                case "Sit":
                    atlas = OldSit;
                    break;
                case "Right":
                    atlas = OldRight;
                    break;
                case "Left":
                    atlas = OldLeft;
                    break;
                case "Sleep":
                    texture = OldSleep;
                    break;
            }
        }
        if (getHealth() <= 0 || getHungry() <= 0 || age > 1095) {
            if (age < 200) {
                texture = smallSleep;
            }
            else if (age > 200 && age < 800) {
                texture = NormalSleep;
            }
            else if (age > 800 && age < 1095) {
                texture = OldSleep;
            }
            death();
        }

        animation = new Animation<>(animationTime, atlas.getRegions());

    }

    private void death(){
        main.database.insert(name, age);
        Gdx.files.local("player.dat").delete();
        main.hamster = new Hamster(main);
        main.setScreen(new ScoreScreen(main));
    }

    public void liveInformation(){
        if (ageTime >= 1){
            ageTime = 0;
            age++;
            money += 25;
        }
        if (time >= 0) {
            time = 0;
            int i = (int) (Math.random() * 100);
            switch (i) {
                case 88:
                    if (getHealth() > 0) setHealth(getHealth() - 1);
                    break;
                case 44:
                    if (getHungry() > 0) setHungry(getHungry() - 1);
                    if (getHungry() == 0 && getHealth() > 5) setHealth(getHealth() / 2);
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

    public void setPosition(String position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setX(float x) {
        X = x;
    }

    @Override
    public void setY(float y) {
        Y = y;
    }

    @Override
    public float getX() {
        return X;
    }

    @Override
    public float getY() {
        return Y;
    }

    public int getGameTime() {
        return gameTime;
    }
}
