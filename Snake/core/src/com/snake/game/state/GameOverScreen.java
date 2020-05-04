package com.snake.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake.game.SnakeGame;

import game.GameScreen;

public class GameOverScreen implements Screen, InputProcessor {
    private Texture background;
    private Texture back;
    private Texture again;
    private Sound buttonSound;

    private Sprite backSprite;
    private Sprite againSprite;

    private SpriteBatch batch;
    private SnakeGame snakeGame;
    private OrthographicCamera camera = new OrthographicCamera(SnakeGame.WIDTH, SnakeGame.HEIGHT);


    public GameOverScreen(SnakeGame snakeGame) {
        batch = new SpriteBatch();
        this.snakeGame = snakeGame;
        camera.setToOrtho(false, SnakeGame.WIDTH , SnakeGame.HEIGHT);
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
        if (backSprite.getBoundingRectangle().contains(pointerX, pointerY)) {
            sound();
            snakeGame.setScreen(new LevelScreen(snakeGame));
            dispose();
        } else if(againSprite.getBoundingRectangle().contains(pointerX,pointerY)) {
            sound();
            snakeGame.setScreen(new GameScreen(snakeGame));
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

    @Override
    public void show() {
        batch = new SpriteBatch();
        background  = new Texture("GameOverScreen.png");

        back  = new Texture("return.PNG");
        backSprite = new Sprite(back);
        backSprite.setSize(80, 80);
        backSprite.setPosition(70,160);

        again = new Texture("again.png");
        againSprite = new Sprite(again);
        againSprite.setSize(80,80);
        againSprite.setPosition(340, 160);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0,0, SnakeGame.WIDTH, SnakeGame.HEIGHT );
        backSprite.draw(batch);
        againSprite.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        back.dispose();
        again.dispose();
        buttonSound.dispose();
        background.dispose();

    }
        private float getCursorToModelX(int screenX, int cursorX)
        {
            return (((float)cursorX) * SnakeGame.WIDTH) / ((float)screenX);
        }

        private float getCursorToModelY(int screenY, int cursorY)
        {
            return ((float)(screenY - cursorY)) * SnakeGame.HEIGHT / ((float)screenY) ;
        }
    private void sound(){
        buttonSound = Gdx.audio.newSound(Gdx.files.internal("buttonSound.mp3"));
        long id = buttonSound.play(0.3f);
        buttonSound.setPitch(id, 1);
        buttonSound.setLooping(id,false);
        snakeGame.setScreen(new StartScreen(snakeGame));
    }
}
