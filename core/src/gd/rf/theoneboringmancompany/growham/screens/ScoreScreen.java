package gd.rf.theoneboringmancompany.growham.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.actors.Back;
import gd.rf.theoneboringmancompany.growham.actors.ScoreTable;
import gd.rf.theoneboringmancompany.growham.actors.Time;
import gd.rf.theoneboringmancompany.growham.actors.Who;
import gd.rf.theoneboringmancompany.growham.utils.MyScreen;

public class ScoreScreen extends MyScreen {
    public final static int NUMBER = 2;

    private Music music;

    private final float musicVolume = 20/100f;

    public ScoreScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        main.stage.addActor(new Back(main, MenuScreen.NUMBER));
        main.stage.addActor(new ScoreTable(main));
        main.stage.addActor(new Who(main));
        main.stage.addActor(new Time(main));

        music = Gdx.audio.newMusic(Gdx.files.internal("Audio/Music/Scores.mp3"));
        music.setLooping(true);
        music.setVolume(musicVolume);
        music.play();
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
