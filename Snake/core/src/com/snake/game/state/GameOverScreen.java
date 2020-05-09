package com.snake.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.snake.game.SnakeGame;

import game.GameScreen;

public class GameOverScreen implements Screen, InputProcessor {
    private Texture background;
    private Texture back;
    private Texture again;
    private Sound buttonSound;

    private SpriteBatch sb;
    public Stage stage;

    private Viewport viewport;


    private Sprite backSprite;
    private Sprite againSprite;

    private SpriteBatch batch;
    private SnakeGame snakeGame;
    private OrthographicCamera camera = new OrthographicCamera(SnakeGame.WIDTH, SnakeGame.HEIGHT);
    private static Label highscoreLabel;
    private static Label scoreLabel;

    int score, highscore;



    public GameOverScreen(SnakeGame snakeGame, int score, SpriteBatch sb, Viewport viewport) {
        batch = new SpriteBatch();
        sb = new SpriteBatch();
        this.snakeGame = snakeGame;
        this.score = score;
        Preferences prefs = Gdx.app.getPreferences("MathSnake");
        this.highscore = prefs.getInteger("highscore", 0);
        camera.setToOrtho(false, SnakeGame.WIDTH , SnakeGame.HEIGHT);
        //Check if score beats  highscore
        if(score > highscore){
            prefs.putInteger("highscore", score);
            prefs.flush();
        }
        viewport = new FitViewport(SnakeGame.WIDTH, SnakeGame.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        highscoreLabel = new Label(String.format("%03d", highscore), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%03d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        highscoreLabel.setFontScale(3);
        scoreLabel.setFontScale(3);
        table.add(scoreLabel).expand().pad(10, 200, -450, 10);
        table.row();
        table.add(highscoreLabel).expand().pad(10, 200, 195, 10);
        stage.addActor(table);


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
        backSprite.setPosition(65,170);

        again = new Texture("again.png");
        againSprite = new Sprite(again);
        againSprite.setSize(80,80);
        againSprite.setPosition(340, 170);
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
        this.stage.draw();
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
