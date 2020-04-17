package gd.rf.theoneboringmancompany.growham;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import gd.rf.theoneboringmancompany.growham.actors.menu.BreakAndPlay;
import gd.rf.theoneboringmancompany.growham.actors.menu.Play;
import gd.rf.theoneboringmancompany.growham.actors.menu.Scores;
import gd.rf.theoneboringmancompany.growham.actors.play.Gym;
import gd.rf.theoneboringmancompany.growham.actors.play.Hamster;
import gd.rf.theoneboringmancompany.growham.actors.play.Sleep;
import gd.rf.theoneboringmancompany.growham.screens.LogoScreen;
import gd.rf.theoneboringmancompany.growham.screens.MenuScreen;
import gd.rf.theoneboringmancompany.growham.screens.PlayScreen;
import gd.rf.theoneboringmancompany.growham.tools.AndroidDatabase;
import gd.rf.theoneboringmancompany.growham.tools.AndroidHandler;
import gd.rf.theoneboringmancompany.growham.tools.Serialization;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

import static gd.rf.theoneboringmancompany.growham.tools.Settings.CAMERA_HEIGHT;
import static gd.rf.theoneboringmancompany.growham.tools.Settings.CAMERA_WIDTH;

public class Main extends Game {
    public BitmapFont fontOrdinary;
    public Viewport viewport;
    public Stage stage;
    public Hamster hamster;
    public Sleep sleep;
    public Gym gym;
    public AssetManager manager;
    public AndroidDatabase database;

    public Play playB;
    public BreakAndPlay breakAndPlay;
    public Scores scores;

    public Main(AndroidHandler handlerDatabase){
        database = new AndroidDatabase(handlerDatabase);
    }



    @Override
	public void create () {
        manager = new AssetManager();
        fontOrdinary = new BitmapFont(Gdx.files.internal(Settings.Path.FONT));

        OrthographicCamera camera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
        camera.position.set(CAMERA_WIDTH /2, CAMERA_HEIGHT /2, 0);
        viewport = new FitViewport(camera.viewportWidth, camera.viewportHeight, camera);

        Gdx.input.setCatchBackKey(true);

        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        //manager.get(Settings.Path.Audio.Sounds.OK, Sound.class);

        if (Gdx.files.local(Settings.Path.SERIALIZATION_FILE).exists()){
            hamster = Serialization.readPlayer();
            hamster.loadTextures(this);
        }
        else {
            hamster = new Hamster(this);
        }

        sleep = new Sleep(this);
        gym = new Gym(this);

        long beginTime = System.currentTimeMillis();

        if (hamster.endTimeFlag){
            long n = (beginTime - hamster.endTime) / 1000;
            long time = n / 10;
            long age = n / 3600;
            for (long i = 0; i < age; i++) {
                hamster.ageTime = 3600;
                hamster.liveInformation();
            }
            for (long i = 0; i < time; i++){
                hamster.time = 10;
                hamster.liveInformation();
            }
        }

       //manager.finishLoading();

        this.setScreen(new LogoScreen(this));
	}

	public void backInput(int i){
        if (Gdx.input.isKeyJustPressed(Input.Keys.BACK)) {
            switch (i) {
                case LogoScreen.NUMBER:
                    stage.clear();
                    Gdx.input.vibrate(20);
                    Gdx.app.exit();
                    break;
                case MenuScreen.NUMBER:
                    stage.clear();
                    Gdx.input.vibrate(20);
                    setScreen(new MenuScreen(this));
                    break;
                case PlayScreen.NUMBER:
                    stage.clear();
                    Gdx.input.vibrate(20);
                    setScreen(new PlayScreen(this));
                    break;
                default:
                    break;
            }
        }
    }

    private void serialization(){
        hamster.endTime = System.currentTimeMillis();
        hamster.endTimeFlag = true;
        hamster.setPose("Sit");
        hamster.setX(hamster.standardX);
        Serialization.savePlayer(hamster);
    }



    @Override
    public void pause() {
        serialization();
        super.pause();
    }

    @Override
	public void dispose () {
        serialization();
        super.dispose();
        fontOrdinary.dispose();
        stage.dispose();
        manager.dispose();
	}
}
