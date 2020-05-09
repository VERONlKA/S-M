package com.snake.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake.game.state.StartScreen;
import  com.snake.game.state.AppPreferences;

public class SnakeGame extends Game {
    public static final int HEIGHT = 800;
    public static final int WIDTH = 480;
    public static final String TITLE = "MathSnake";
    private Sound applesound;
    private Music backgroundmusic;
    private Sound buttonSound;
    private SpriteBatch batch;
    private AppPreferences preferences;

    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new GameScreen(this));
        applesound = Gdx.audio.newSound(Gdx.files.internal("applesound.mp3"));
        backgroundmusic = Gdx.audio.newMusic(Gdx.files.internal("musicbackround.mp3"));
        buttonSound = Gdx.audio.newSound(Gdx.files.internal("buttonSound.mp3"));
        backgroundmusic.setLooping(true);
        backgroundmusic.setVolume(0.1f);
        backgroundmusic.play();
        preferences = new AppPreferences();
    }

    public AppPreferences getPreferences() {
        return this.preferences;
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        backgroundmusic.dispose();
        buttonSound.dispose();
    }


}
