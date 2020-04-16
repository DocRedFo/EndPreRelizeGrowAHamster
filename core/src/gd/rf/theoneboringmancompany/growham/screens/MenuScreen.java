package gd.rf.theoneboringmancompany.growham.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.actors.menu.BreakAndPlay;
import gd.rf.theoneboringmancompany.growham.actors.menu.Exit;
import gd.rf.theoneboringmancompany.growham.actors.menu.Play;
import gd.rf.theoneboringmancompany.growham.actors.menu.Scores;
import gd.rf.theoneboringmancompany.growham.tools.MyScreen;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class MenuScreen extends MyScreen {
    public static final int NUMBER = 1;

    private Music music;

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

        music = Gdx.audio.newMusic(Gdx.files.internal(Settings.Path.Audio.Music.MENU));
        music.setLooping(true);
        music.setVolume(Settings.MusicAndSound.MUSIC_VOLUME);
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
