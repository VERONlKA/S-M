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
import com.snake.game.state.GameState;
import com.snake.game.state.GameStateManager;
import com.snake.game.state.MenuState;


public class SnakeGame extends Game {
    public static final int HEGHT = 800;
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
        Gdx.gl.glClearColor(1, 0, 0, 1);
        batch = new SpriteBatch();
        gsm = new GameStateManager();
        gsm.push(new MenuState(gsm));
        apple = new Texture("apple.png");
        bodySnake = new Texture("BodySnake.png");
        applesound = Gdx.audio.newSound(Gdx.files.internal("applesound.mp3"));
        backroundmusic = Gdx.audio.newMusic(Gdx.files.internal("musicbackround.mp3"));
        backroundmusic.setLooping(true);
        backroundmusic.play();
        //gsm.push(new GameState(gsm));


    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
    }
}

