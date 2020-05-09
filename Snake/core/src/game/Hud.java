package game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.snake.game.SnakeGame;
import com.snake.game.state.GameOverScreen;

public class Hud {

    private static Label countduwnLabel;
    private static Label scoreLabel;
    private static Integer worldTimer;
    private static Integer score;
    private float timeCount;
    private GameState gameState;
    private SpriteBatch sb;
    private static Label examples;
    public static Label[] example;
    private SnakeGame snakeGame;
    public Stage stage;

    private Viewport viewport;

    public Hud(SpriteBatch sb, Viewport viewport, SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        viewport = new FitViewport(SnakeGame.WIDTH, SnakeGame.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        worldTimer = 60;
        timeCount = 0;
        score = 0;
        example = new Label[1];
        example[0] = new Label("   ", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        countduwnLabel = new Label(String.format("%02d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%03d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel.setFontScale(2,2);
        countduwnLabel.setFontScale(2f,2f);
        example[0].setFontScale(2,2);


        table.add(scoreLabel).expand().pad(10, 40, 640, 10);

            table.add(example[0]).expand().pad(10, 80, 640, 10);

        table.add(countduwnLabel).expand().pad(10, 70, 640, 30);
        stage.addActor(table);
        }



    public void update(float delta) {
        timeCount += delta;
        if (timeCount >= 1) {
            worldTimer--;
            countduwnLabel.setText(String.format("%03d", worldTimer));
            timeCount = 0;
} else if (worldTimer <= 0) {

            snakeGame.setScreen(new GameOverScreen(snakeGame, score, sb, viewport));
        }

    }

    public static void addScore(int value){
        score += value;
        scoreLabel.setText(String.format("%03d", score));
    }
    public static void addTime(int value){
        worldTimer += value;
        countduwnLabel.setText(String.format("%03d", worldTimer));
    }
    public static void SetText(){
       examples.setText((CharSequence) example[(int) MathUtils.random.nextInt(example.length-1)]);
        }
    }

