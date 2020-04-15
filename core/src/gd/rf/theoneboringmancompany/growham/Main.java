package gd.rf.theoneboringmancompany.growham;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import gd.rf.theoneboringmancompany.growham.actors.FitPlay;
import gd.rf.theoneboringmancompany.growham.actors.Hamster;
import gd.rf.theoneboringmancompany.growham.actors.Sleep;
import gd.rf.theoneboringmancompany.growham.screens.LogoScreen;
import gd.rf.theoneboringmancompany.growham.screens.MenuScreen;
import gd.rf.theoneboringmancompany.growham.screens.PlayRoomScreen;
import gd.rf.theoneboringmancompany.growham.utils.AndroidDatabase;
import gd.rf.theoneboringmancompany.growham.utils.AndroidHandler;
import gd.rf.theoneboringmancompany.growham.utils.Serialization;

public class Main extends Game {
    private SpriteBatch batch;
    public BitmapFont fontOrdinary;
    public Viewport viewport;
    public Stage stage;
    public Hamster hamster;
    public Sleep sleep;
    public FitPlay fitPlay;

    public AndroidDatabase database;

    public long beginTime;

    public Main(AndroidHandler handlerDatabase){
        database = new AndroidDatabase(handlerDatabase);
    }



    @Override
	public void create () {
		batch = new SpriteBatch();

        fontOrdinary = new BitmapFont(Gdx.files.internal("BitmapFonts/ordinarytext.fnt"));

        float CAMERA_HEIGHT = 810;
        float CAMERA_WIDTH = 1440;

        OrthographicCamera camera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
        camera.position.set(CAMERA_WIDTH /2, CAMERA_HEIGHT /2, 0);
        viewport = new FitViewport(camera.viewportWidth, camera.viewportHeight, camera);

        Gdx.input.setCatchBackKey(true);

        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        Gdx.gl.glClearColor(0,0,0,1);

        if (Gdx.files.local("player.dat").exists()){
            hamster = Serialization.readPlayer();
            hamster.loadTextures(this);
        }
        else {
            hamster = new Hamster(this);
        }

        sleep = new Sleep(this);
        fitPlay = new FitPlay(this);

        beginTime = System.currentTimeMillis();

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

        this.setScreen(new LogoScreen(this));
	}

	public void backInput(int i){
        if (Gdx.input.isKeyPressed (Input.Keys.BACK)) {
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
                case PlayRoomScreen.NUMBER:
                    stage.clear();
                    Gdx.input.vibrate(20);
                    setScreen(new PlayRoomScreen(this));
                    break;
                default:
                    break;
            }
        }
    }

    private void serialization(){
        hamster.endTime = System.currentTimeMillis();
        hamster.endTimeFlag = true;
        hamster.setPosition("Sit");
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
        batch.dispose();
        fontOrdinary.dispose();
        stage.dispose();
	}
}
