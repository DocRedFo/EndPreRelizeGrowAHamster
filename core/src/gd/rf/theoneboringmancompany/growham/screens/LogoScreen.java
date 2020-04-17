package gd.rf.theoneboringmancompany.growham.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;

import gd.rf.theoneboringmancompany.growham.Main;
import gd.rf.theoneboringmancompany.growham.actors.logo.Logo;
import gd.rf.theoneboringmancompany.growham.actors.logo.Text;
import gd.rf.theoneboringmancompany.growham.actors.menu.BreakAndPlay;
import gd.rf.theoneboringmancompany.growham.actors.menu.Play;
import gd.rf.theoneboringmancompany.growham.actors.menu.Scores;
import gd.rf.theoneboringmancompany.growham.tools.MyScreen;
import gd.rf.theoneboringmancompany.growham.tools.Settings;

public class LogoScreen extends MyScreen {
    public static final int NUMBER = 0;

    private boolean textAdd = false;
    private boolean updateManager = true;

    public LogoScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        super.show();
        main.manager.load(Settings.Path.TextureAtlas.SCORES_BUTTON_ATLAS, TextureAtlas.class);
        main.manager.load(Settings.Path.TextureAtlas.BREAK_AND_PLAY_BUTTON_ATLAS, TextureAtlas.class);
        main.manager.load(Settings.Path.TextureAtlas.PLAY_BUTTON_ATLAS, TextureAtlas.class);
        main.stage.addActor(new Logo(main));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (main.manager.update() && updateManager){
            //main.manager.get(Settings.Path.Audio.Sounds.OK, Sound.class)
              //      .play(Settings.MusicAndSound.SOUND_VOLUME);
            main.playB = new Play(main);
            main.breakAndPlay = new BreakAndPlay(main);
            main.scores = new Scores(main);
            main.stage.addActor(new Text(main));
            updateManager = false;
        }
    }
}
