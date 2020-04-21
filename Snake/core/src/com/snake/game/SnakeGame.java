package com.snake.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.snake.game.state.DifficultyLevel;
import com.snake.game.state.GameStateManager;
import com.snake.game.state.StartScreen;


public class SnakeGame extends Game {
    public static final int HEIGHT = 800;
    public static final int WIDTH = 480;
    public static final String TITLE = "Snake&Math";
    private Texture apple;
    private Texture bodySnake;
    private Sound applesound;
    private Music backroundmusic;
    private Rectangle snake;
    private GameStateManager gsm;
    private SpriteBatch batch;

    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new StartScreen(this));
        applesound = Gdx.audio.newSound(Gdx.files.internal("applesound.mp3"));
        backroundmusic = Gdx.audio.newMusic(Gdx.files.internal("musicbackround.mp3"));
        backroundmusic.setLooping(true);
        backroundmusic.play();
    }

    @Override
    public void render() {
        super.render();

    }
    @Override
    public void dispose() {
        batch.dispose();}
}
