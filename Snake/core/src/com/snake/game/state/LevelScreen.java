package com.snake.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake.game.SnakeGame;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class LevelScreen implements Screen {

    private Texture background;
    private Texture easy;
    private Texture medium;
    private Texture hard;
    private Texture back;
    private SpriteBatch batch;
    private SnakeGame snakeGame;
    private OrthographicCamera camera = new OrthographicCamera(SnakeGame.WIDTH, SnakeGame.HEIGHT);

    public LevelScreen(SnakeGame snakeGame) {
        batch = new SpriteBatch();
        this.snakeGame = snakeGame;
        camera.setToOrtho(false, SnakeGame.WIDTH , SnakeGame.HEIGHT);
    }

    @Override
    public void show() {
        background = new Texture("lakeBG.JPEG");
        easy = new Texture("easy.PNG");
        medium = new Texture("medium.PNG");
        hard = new Texture("hard.PNG");
        back = new Texture("return.PNG");
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0,0, SnakeGame.WIDTH, SnakeGame.HEIGHT);
        batch.draw(back, 79,700, 60,60);
        batch.draw(easy, 50,450, 380, 130);
        batch.draw(medium, 50, 300, 380,130);
        batch.draw(hard, 50, 150, 380,130);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() { }
    @Override
    public void resume() {  }
    @Override
    public void hide() { }
    @Override
    public void dispose() {
        back.dispose();
        background.dispose();
        easy.dispose();
        hard.dispose();
        medium.dispose();
    }
}
