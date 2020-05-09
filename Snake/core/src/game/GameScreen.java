package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.snake.game.SnakeGame;

import sprites.Bodypart;

public class GameScreen implements Screen {
    public static final int width = 480;
    public static final int height = 800;
    private OrthographicCamera camera = new OrthographicCamera(width, height);
    private Viewport viewport;
    private SnakeGame snakeGame;
    private GameState gameState ;
    public static Texture background;
    private SpriteBatch sb;
    private Bodypart bodypart;


    public GameScreen(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        gameState = new GameState(snakeGame);
        camera.setToOrtho(false, width, height);
        viewport = new FitViewport(width, height, camera);
        viewport.apply();
        loadTextures();
    }
    private void loadTextures() {
        background = new Texture("background.png");}

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gameState.update(delta, viewport);
        camera.update ();
        viewport.apply ();
        Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);
        gameState.draw(width, height, camera);

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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

    }
}
