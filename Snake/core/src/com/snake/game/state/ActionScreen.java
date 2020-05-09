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
import java.applet.Applet;

public class ActionScreen implements Screen, InputProcessor {
    private Texture background, addition, division, multiplication, subtraction, back, settingsBtn;
    private Sprite backButtonSprite,additionSprite,subtractionSprite,divisionSprite,multiplicationSprite,settingsBTNSprite;
    private SpriteBatch batch;
    private Sound buttonSound;


public class ActionScreen implements Screen, InputProcessor {
    private Texture background;
    private Texture addition;
    private Texture division;
    private Texture multiplication;
    private Texture subtraction;
    private Texture back;
    private Texture settingsBtn;

    private Sprite backButtonSprite;
    private Sprite additionSprite;
    private Sprite subtractionSprite;
    private Sprite divisionSprite;
    private Sprite multiplicationSprite;
    private Sprite settingsBTNSprite;
    private SpriteBatch batch;
    private Sound buttonSound;


    private SnakeGame snakeGame;
    private OrthographicCamera camera = new OrthographicCamera(SnakeGame.WIDTH, SnakeGame.HEIGHT);

    public ActionScreen(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        camera.setToOrtho(false, SnakeGame.WIDTH , SnakeGame.HEIGHT);
        buttonSound = Gdx.audio.newSound(Gdx.files.internal("buttonSound.mp3"));
        batch = new SpriteBatch();
        this.snakeGame = snakeGame;
        camera.setToOrtho(false, SnakeGame.WIDTH , SnakeGame.HEIGHT);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        background  = new Texture("lakeBG.JPEG");

        addition  = new Texture("addition.PNG");
        additionSprite = new Sprite(addition);
        additionSprite.setSize(180, 180);
        additionSprite.setPosition(60,380);

        subtraction = new Texture("subtraction.PNG");

        subtraction = new Texture("substraction.PNG");

        subtractionSprite = new Sprite(subtraction);
        subtractionSprite.setSize(180,180);
        subtractionSprite.setPosition(240, 380);

        division = new Texture("division.PNG");
        divisionSprite = new Sprite(division);
        divisionSprite.setSize(180,180);
        divisionSprite.setPosition(60,220);

        multiplication = new Texture("multiplication.PNG");
        multiplicationSprite = new Sprite(multiplication);
        multiplicationSprite.setSize(180,180);
        multiplicationSprite.setPosition(240, 220);

        settingsBtn = new Texture("settingsButton.PNG");
        settingsBTNSprite = new Sprite(settingsBtn);
        settingsBTNSprite.setSize(60,60);
        settingsBTNSprite.setPosition(345, 700);

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
        batch.draw(background, 0,0, SnakeGame.WIDTH, SnakeGame.HEIGHT );
        settingsBTNSprite.draw(batch);
        additionSprite.draw(batch);
        subtractionSprite.draw(batch);
        divisionSprite.draw(batch);
        multiplicationSprite.draw(batch);
        backButtonSprite.draw(batch);
        batch.end();
    }

    private void sound(){

        buttonSound.play(0.3f);

        buttonSound = Gdx.audio.newSound(Gdx.files.internal("buttonSound.mp3"));
        long id = buttonSound.play(0.3f);
        buttonSound.setPitch(id, 1);
        buttonSound.setLooping(id,false);
        snakeGame.setScreen(new StartScreen(snakeGame));
    }

    @Override
    public void resize(int width, int height) { }
    @Override
    public void pause() { }
    @Override
    public void resume() { }
    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        background.dispose();
        back.dispose();
        addition.dispose();
        subtraction.dispose();
        multiplication.dispose();
        division.dispose();
        settingsBtn.dispose();
        buttonSound.dispose();
        batch.dispose();
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
        if (backButtonSprite.getBoundingRectangle().contains(pointerX, pointerY)) {
            sound();
            snakeGame.setScreen(new StartScreen(snakeGame));
        } else if(additionSprite.getBoundingRectangle().contains(pointerX,pointerY)){
            sound();
            snakeGame.setScreen(new LevelScreen(snakeGame));

        } else if(subtractionSprite.getBoundingRectangle().contains(pointerX,pointerY)) {
            sound();
            snakeGame.setScreen(new LevelScreen(snakeGame));

        } else if(divisionSprite.getBoundingRectangle().contains(pointerX,pointerY)) {
            sound();
            snakeGame.setScreen(new LevelScreen(snakeGame));

        } else if(multiplicationSprite.getBoundingRectangle().contains(pointerX,pointerY)) {
            sound();
            snakeGame.setScreen(new LevelScreen(snakeGame));

        }else if (settingsBTNSprite.getBoundingRectangle().contains(pointerX,pointerY)){
            sound();
            snakeGame.setScreen(new PreferencesScreen(snakeGame));
            dispose();
        } else if(additionSprite.getBoundingRectangle().contains(pointerX,pointerY)){
            sound();
            snakeGame.setScreen(new LevelScreen(snakeGame));
            dispose();
        } else if(subtractionSprite.getBoundingRectangle().contains(pointerX,pointerY)) {
            sound();
            snakeGame.setScreen(new LevelScreen(snakeGame));
            dispose();
        } else if(divisionSprite.getBoundingRectangle().contains(pointerX,pointerY)) {
            sound();
            snakeGame.setScreen(new LevelScreen(snakeGame));
            dispose();
        } else if(multiplicationSprite.getBoundingRectangle().contains(pointerX,pointerY)) {
            sound();
            snakeGame.setScreen(new LevelScreen(snakeGame));
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