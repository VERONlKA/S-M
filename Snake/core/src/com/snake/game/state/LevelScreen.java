package com.snake.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake.game.SnakeGame;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class LevelScreen implements Screen, InputProcessor {

    private Texture background;
    private Texture easy;
    private Texture medium;
    private Texture hard;
    private Texture back;
    private SpriteBatch batch;
    private SnakeGame snakeGame;
    private OrthographicCamera camera = new OrthographicCamera(SnakeGame.WIDTH, SnakeGame.HEIGHT);
    private Sprite backButtonSprite;

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
        backButtonSprite= new Sprite(back);
        backButtonSprite.setSize(60,60);
        backButtonSprite.setPosition(70, 700);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0,0, SnakeGame.WIDTH, SnakeGame.HEIGHT);
        batch.draw(easy, 50,450, 380, 130);
        batch.draw(medium, 50, 300, 380,130);
        batch.draw(hard, 50, 150, 380,130);
        backButtonSprite.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() { }
    @Override
    public void resume() { }
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

    @Override
    public boolean keyDown(int keycode) { return false; }

    @Override
    public boolean keyUp(int keycode) { return false; }

    @Override
    public boolean keyTyped(char character)  { return false; }
    @Override

    public boolean touchDown(int screenX, int screenY, int pointer, int button)  { return false; }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        float pointerX = getCursorToModelX(Gdx.graphics.getWidth(), screenX);
        float pointerY = getCursorToModelY(Gdx.graphics.getHeight() , screenY);
        if (backButtonSprite.getBoundingRectangle().contains(pointerX, pointerY)) {
            snakeGame.setScreen(new ActionScreen(snakeGame));
            dispose();
        }
        return true;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)  {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)  {
        return false;
    }

    @Override
    public boolean scrolled(int amount)  {
        return false;
    }


    private float getCursorToModelX(int screenX, int cursorX)
    {
        return (((float)cursorX) * SnakeGame.WIDTH) / ((float)screenX);
    }

    private float getCursorToModelY(int screenY, int cursorY)
    {
        return ((float)(screenY - cursorY)) * SnakeGame.HEIGHT / ((float)screenY) ;
    }

}
