package com.snake.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.GameScreen;


public class SnakeGame extends Game {
    public static final int HEGHT = 800;
    public static final int WIDTH = 480;
    public static final String TITLE = "Snake&Math";
    private Sound applesound;
    private Music backroundmusic;
    private SpriteBatch batch;

    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new GameScreen(this));
        applesound = Gdx.audio.newSound(Gdx.files.internal("applesound.mp3"));
        backroundmusic = Gdx.audio.newMusic(Gdx.files.internal("musicbackround.mp3"));
        backroundmusic.setLooping(true);
        backroundmusic.play();
        //gsm.push(new GameState(gsm));


    }

    @Override
    public void render() {
        super.render();
    }
    @Override
    public void dispose() {
        batch.dispose();}
}

