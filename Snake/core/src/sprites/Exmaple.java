package sprites;

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

import java.util.Random;

public class Exmaple {
    private SpriteBatch sb;
    public static Label examples;
    public static Label[] example;
    private SnakeGame snakeGame;
    public Stage stage;

    private Viewport viewport;
    public Exmaple(SnakeGame snakeGame, SpriteBatch sb, Viewport viewport){
        this.snakeGame = snakeGame;
        viewport = new FitViewport(SnakeGame.WIDTH, SnakeGame.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        example = new Label[9];
        example[0] = new Label("1*2", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        example[1] = new Label("1*3", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        example[2] = new Label("1*4", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        example[3] = new Label("1*5", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        example[4] = new Label("1*6", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        example[5] = new Label("1*7", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        example[6] = new Label("1*8", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        example[7] = new Label("1*9", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        example[8] = new Label("2*4", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        example[0].setFontScale(2,2);
        example[1].setFontScale(2,2);
        example[2].setFontScale(2,2);
        example[3].setFontScale(2,2);
        example[4].setFontScale(2,2);
        example[5].setFontScale(2,2);
        example[6].setFontScale(2,2);
        example[7].setFontScale(2,2);
        example[8].setFontScale(2,2);
        Random random = new Random();
        examples = (example[(int) random.nextInt(example.length-1)]);
                table.add(example[0]).pad(10, 20, -150, 10);
        stage.addActor(table);
    }
}
