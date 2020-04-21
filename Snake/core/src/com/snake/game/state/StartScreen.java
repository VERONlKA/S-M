package com.snake.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake.game.SnakeGame;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class StartScreen implements Screen {

    private OrthographicCamera camera = new OrthographicCamera(SnakeGame.WIDTH, SnakeGame.HEIGHT);
    private Texture backGroundTexture;
    private Texture startButtonTexture;
    private Texture logoTexture;
    private SpriteBatch batch;
    private SnakeGame snakeGame;

    public StartScreen(SnakeGame snakeGame) {
        batch = new SpriteBatch();
        this.snakeGame = snakeGame;
        camera.setToOrtho(false, SnakeGame.WIDTH , SnakeGame.HEIGHT);
    }

    @Override
    public void show() {
        logoTexture = new Texture("logoSnake.png");
        backGroundTexture = new Texture("menuBackGR.jpg");
        startButtonTexture = new Texture("playButton.png");

        Sprite startButtonSprite = new Sprite(startButtonTexture);
        startButtonSprite.setSize(105,105);
        startButtonSprite.setPosition(190, 140);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(backGroundTexture, 0,0, SnakeGame.WIDTH,SnakeGame.HEIGHT);
        batch.draw(logoTexture, 95, 245, 290,290);
        batch.end();
    }

    @Override
    public void resize(int width, int height) { }
    @Override
    public void pause() { }
    @Override
    public void resume() { }
    @Override
    public void hide() { }

    @Override
    public void dispose() {
        backGroundTexture.dispose();
        startButtonTexture.dispose();
        logoTexture.dispose();
    }

}
