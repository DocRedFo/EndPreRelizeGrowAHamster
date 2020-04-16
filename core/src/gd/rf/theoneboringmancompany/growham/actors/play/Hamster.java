package gd.rf.theoneboringmancompany.growham.actors.play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.io.Serializable;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.screens.ScoreScreen;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class Hamster extends Actor implements Serializable {
    private transient Main main;

    protected String name;

    public long endTime;
    public boolean endTimeFlag = false;

    private boolean hasNamed = false;

    private int age = 1;
    private int health = 100;
    private int hungry = 100;
    private int money = 100;
    private int roomLevel = 1;

    public float time = 0f;
    public float ageTime = 0f;
    private float delta = 0f;

    final int bPlay = 2;
    final int bAll = 0;
    final int bSleep = 1;
    int button = 0;

    float HSize = 342;

    private transient TextureAtlas atlas;
    private transient Texture texture;
    private transient Animation<TextureAtlas.AtlasRegion> animation;

    public final float standardX;

    private float X;
    private float Y;
    private String pose;

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
        float standardY = main.stage.getHeight() / 21;

        pose = "Sit";
        X = standardX;
        Y = standardY;
        setPosition(X, Y);

        loadTextures(main);
    }

    public void loadTextures(Main main){
        this.main = main;

        smallSleep = new Texture(Settings.Hamster.Small.SLEEP);
        NormalSleep = new Texture(Settings.Hamster.Normal.SLEEP);
        OldSleep = new Texture(Settings.Hamster.Old.SLEEP);

        smallSit = new TextureAtlas(Settings.Hamster.Small.SIT);
        NormalSit = new TextureAtlas(Settings.Hamster.Normal.SIT);
        OldSit = new TextureAtlas(Settings.Hamster.Old.SIT);

        smallRight = new TextureAtlas(Settings.Hamster.Small.RIGHT);
        NormalRight = new TextureAtlas(Settings.Hamster.Normal.RIGHT);
        OldRight = new TextureAtlas(Settings.Hamster.Old.RIGHT);

        smallLeft = new TextureAtlas(Settings.Hamster.Small.LEFT);
        NormalLeft = new TextureAtlas(Settings.Hamster.Normal.LEFT);
        OldLeft = new TextureAtlas(Settings.Hamster.Old.LEFT);

        hamsterUpdate();

        animation = new Animation<>(Settings.Animation.HAMSTER_ANIMATION_SPEED, atlas.getRegions());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        delta += Gdx.graphics.getDeltaTime();
        ageTime += Gdx.graphics.getDeltaTime();
        time += Gdx.graphics.getDeltaTime();

        liveInformation();
        hamsterUpdate();

        if (pose.equals("Sleep")) {
            batch.draw(texture, X, Y);
        }
        else {
            batch.draw(animation.getKeyFrame(delta, true), X, Y);
        }

        setPosition(X, Y);
    }

    private void hamsterUpdate() {
        if (age < 200) {
            switch (pose) {
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
            switch (pose) {
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
            switch (pose) {
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

        animation = new Animation<>(Settings.Animation.HAMSTER_ANIMATION_SPEED, atlas.getRegions());

    }

    private void death(){
        main.database.insert(name, age);
        if (Gdx.files.local(Settings.Path.SERIALIZATION_FILE).exists())
        Gdx.files.local(Settings.Path.SERIALIZATION_FILE).delete();
        main.setScreen(new ScoreScreen(main));
        main.hamster = new Hamster(main);
    }

    public void liveInformation(){
        if (ageTime >= 3600){
            ageTime = 0;
            age++;
            money += 25;
        }
        if (time >= 10) {
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

    public int getHealth() {
        return health;
    }

    int getAge() {
        return age;
    }

    public int getMoney() {
        return money;
    }

    public int getHungry() {
        return hungry;
    }

    public int getRoomLevel() {
        return roomLevel;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setHungry(int hungry) {
        this.hungry = hungry;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setRoomLevel(int roomLevel) {
        this.roomLevel = roomLevel;
    }

    public void setHasNamed(boolean hasNamed) {
        this.hasNamed = hasNamed;
    }

    public void setPose(String pose) {
        this.pose = pose;
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

}
