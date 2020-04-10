package gd.rf.theoneboringmancompany.growham.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.actors.Emotions;
import gd.rf.theoneboringmancompany.growham.actors.FitPlay;
import gd.rf.theoneboringmancompany.growham.actors.Information;
import gd.rf.theoneboringmancompany.growham.actors.Market;
import gd.rf.theoneboringmancompany.growham.actors.Room;
import gd.rf.theoneboringmancompany.growham.actors.Sleep;
import gd.rf.theoneboringmancompany.growham.actors.WindowNameEnter;
import gd.rf.theoneboringmancompany.growham.utils.MyScreen;

public class PlayRoomScreen extends MyScreen {
    public final static int NUMBER = 3;

    private Music music;

    private final float musicVolume = 20/100f;


    public PlayRoomScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        main.stage.addActor(new Room(main));
        main.stage.addActor(new Information(main));
        main.stage.addActor(new Market(main));
        main.stage.addActor(main.hamster);
        main.stage.addActor(new Sleep(main));
        main.stage.addActor(new FitPlay(main));
        main.stage.addActor(new Emotions(main));

        music = Gdx.audio.newMusic(Gdx.files.internal("Audio/Music/Ordinary.mp3"));
        music.setLooping(true);
        music.setVolume(musicVolume);
        music.play();

        if (!main.hamster.isHasNamed()){
            main.setScreen(new WindowNameEnter(main, this));
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        main.backInput(MenuScreen.NUMBER);
    }

    @Override
    public void hide() {
        music.pause();
        super.hide();
    }

    @Override
    public void dispose() {
        super.dispose();
        music.dispose();
    }
}
