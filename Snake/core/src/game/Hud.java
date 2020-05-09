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
import com.snake.game.state.StartScreen;

public class Hud {
    public Stage stage;
    private Label countduwnLabel;
    private static Label scoreLabel;
    private Label timeLabel;
    private Label SCORE;
    private Label Example;
    private Label RandomExmple;
    private Label[] example;
    private Integer worldTimer;
    private static Integer score;
    private SnakeGame snakeGame;
    private float timeCount;

    private Viewport viewport;

    public Hud(SpriteBatch sb, Viewport viewport) {
        viewport = new FitViewport(SnakeGame.WIDTH, SnakeGame.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        worldTimer = 60;
        timeCount = 0;
        score = 0;
        example = new Label[3];
        example[0] = new Label("1*1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        example[1] = new Label("1*3", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        example[2] = new Label("1*4", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        countduwnLabel = new Label(String.format("%02d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%03d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        RandomExmple = new Label("", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        SCORE = new Label("SCORE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Example = new Label("EXAMPLE", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(SCORE).pad(10, 10, 10, -10);
        table.add(Example).pad(10, 10, 10, -10);
        table.add(timeLabel).pad(10, 10, 10, -10);
        table.row();
        table.add(scoreLabel).expand().pad(10, 10, 1000, -10);
        for (int i = 0; i < 1; i++) {
            example[i] = (example[(int) MathUtils.random(example.length)]);
            table.add(example[i]).expand().pad(10, 10, 1000, -10);

        }
        table.add(countduwnLabel).expand().pad(10, 10, 1000, -10);
        stage.addActor(table);
    }

    public void update(float delta) {
        timeCount += delta;
        if (timeCount >= 1) {
            worldTimer--;
            countduwnLabel.setText(String.format("%03d", worldTimer));
            timeCount = 0;

        }
    }
    public static void addScore(int value){
        score += value;
        scoreLabel.setText(String.format("%03d", score));
    }
}
