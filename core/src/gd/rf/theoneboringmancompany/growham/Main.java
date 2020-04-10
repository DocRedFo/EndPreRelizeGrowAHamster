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

import gd.rf.theoneboringmancompany.growham.actors.Hamster;
import gd.rf.theoneboringmancompany.growham.screens.LogoScreen;
import gd.rf.theoneboringmancompany.growham.screens.MenuScreen;
import gd.rf.theoneboringmancompany.growham.screens.PlayRoomScreen;

public class Main extends Game {
    private SpriteBatch batch;
    public BitmapFont fontOrdinary;
    public Viewport viewport;
    public Stage stage;
    public Hamster hamster;
    public long beginTime;

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

        beginTime = System.currentTimeMillis();

        hamster = new Hamster(this);

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

	@Override
	public void dispose () {
        super.dispose();
        batch.dispose();
        fontOrdinary.dispose();
        stage.dispose();
	}
}
