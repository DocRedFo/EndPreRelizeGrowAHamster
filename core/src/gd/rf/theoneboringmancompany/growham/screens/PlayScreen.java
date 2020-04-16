package gd.rf.theoneboringmancompany.growham.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.actors.play.Emotions;
import gd.rf.theoneboringmancompany.growham.actors.play.Information;
import gd.rf.theoneboringmancompany.growham.actors.play.Market;
import gd.rf.theoneboringmancompany.growham.actors.play.Room;
import gd.rf.theoneboringmancompany.growham.tools.MyScreen;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class PlayScreen extends MyScreen {
    public final static int NUMBER = 3;

    private Music music;

    public PlayScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        main.stage.addActor(new Room(main));
        main.stage.addActor(new Information(main));
        main.stage.addActor(new Market(main));
        main.stage.addActor(main.hamster);
        main.stage.addActor(main.sleep);
        main.stage.addActor(main.gym);
        main.stage.addActor(new Emotions(main));

        music = Gdx.audio.newMusic(Gdx.files.internal(Settings.Path.Audio.Music.PLAY));
        music.setLooping(true);
        music.setVolume(Settings.MusicAndSound.MUSIC_VOLUME);
        music.play();

        if (!main.hamster.isHasNamed()){
            main.setScreen(new NameWindow(main, this));
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
