package gd.rf.theoneboringmancompany.growham.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.actors.BreakAndPlay;
import gd.rf.theoneboringmancompany.growham.actors.Exit;
import gd.rf.theoneboringmancompany.growham.actors.Play;
import gd.rf.theoneboringmancompany.growham.actors.Scores;
import gd.rf.theoneboringmancompany.growham.utils.MyScreen;

public class MenuScreen extends MyScreen {
    public static final int NUMBER = 1;

    private Music music;

    private final float musicVolume = 20/100f;

    public MenuScreen(Main main) {
        super(main);
    }


    @Override
    public void show() {
        super.show();
        main.fontOrdinary.getData().setScale(2.5f);

        main.stage.addActor(new Play(main));
        main.stage.addActor(new Scores(main));
        main.stage.addActor(new BreakAndPlay(main));
        main.stage.addActor(new Exit(main));

        music = Gdx.audio.newMusic(Gdx.files.internal("Audio/Music/Menu.mp3"));
        music.setLooping(true);
        music.setVolume(musicVolume);
        music.play();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        main.backInput(0);
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
