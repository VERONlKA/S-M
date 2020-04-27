package com.snake.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake.game.SnakeGame;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class StartScreen implements Screen, InputProcessor {
    private OrthographicCamera camera = new OrthographicCamera(SnakeGame.WIDTH, SnakeGame.HEIGHT);
    private Texture backGroundTexture;
    private Texture startButtonTexture;
    private Texture logoTexture;
    private SpriteBatch batch;
    private SnakeGame snakeGame;
    private Sprite startButtonSprite;
    private Sound buttonSound;

    public StartScreen(SnakeGame snakeGame) {
        batch = new SpriteBatch();
        this.snakeGame = snakeGame;
        camera.setToOrtho(false, SnakeGame.WIDTH, SnakeGame.HEIGHT);
    }

    @Override
    public void show () {
        logoTexture = new Texture("logoSnake.PNG");
        backGroundTexture = new Texture("menuBackGR.JPG");
        startButtonTexture = new Texture("playButton.PNG");
        startButtonSprite = new Sprite(startButtonTexture);
        startButtonSprite.setSize(105, 105);
        startButtonSprite.setPosition(190, 140);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render ( float delta){
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(backGroundTexture, 0, 0, SnakeGame.WIDTH, SnakeGame.HEIGHT);
        batch.draw(logoTexture, 95, 245, 290, 290);
        startButtonSprite.draw(batch);
        batch.end();
    }

    @Override
    public void resize ( int width, int height){ }
    @Override
    public void pause () { }
    @Override
    public void resume () { }
    @Override
    public void hide () { }

    @Override
    public void dispose () {
        backGroundTexture.dispose();
        startButtonTexture.dispose();
        logoTexture.dispose();
        startButtonSprite.getTexture().dispose();
        buttonSound.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        float pointerX = getCursorToModelX(Gdx.graphics.getWidth(), screenX);
        float pointerY = getCursorToModelY(Gdx.graphics.getHeight() , screenY);
        if (startButtonSprite.getBoundingRectangle().contains(pointerX, pointerY)) {
            buttonSound = Gdx.audio.newSound(Gdx.files.internal("buttonSound.mp3"));
            long id = buttonSound.play(0.3f);
            buttonSound.setPitch(id, 1);
            buttonSound.setLooping(id,false);
            snakeGame.setScreen(new ActionScreen(snakeGame));
            dispose();
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
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
