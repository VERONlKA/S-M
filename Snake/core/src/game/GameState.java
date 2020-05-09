package game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Queue;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.snake.game.SnakeGame;
import com.snake.game.state.GameOverScreen;

import sprites.Bodypart;
import sprites.Controls;
import sprites.Exmaple;
import sprites.Numbers;

public class GameState {
    private int x;
    private int y;
    private float mTimer = 0;


    public static final int boardSize = 30;
    private int yOffset = 20;
    private Numbers numbers;
    private Numbers numbers1;
    private Numbers numbers2;
    private Hud hud;
    private Exmaple exmaple;
    private int NumberQuestion;
    public static final float scaleSnake =  boardSize;

     private SnakeGame snakeGame;

    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Queue<Bodypart> mBody = new Queue<>();
    private Texture background;
    private SpriteBatch sb;
    private Controls controls = new Controls();
    int score;


    private Viewport viewport;
    private OrthographicCamera camera = new OrthographicCamera(SnakeGame.WIDTH, SnakeGame.HEIGHT);




    public GameState(SnakeGame snakeGame) {
        sb = new SpriteBatch();
        hud = new Hud(sb, viewport, snakeGame);
        exmaple = new Exmaple(snakeGame, sb, viewport);
        camera.setToOrtho(false, SnakeGame.WIDTH, SnakeGame.HEIGHT);
        NumberQuestion = 1;
        score = 0;
        numbers = new Numbers(boardSize, NumberQuestion);
        numbers1 = new Numbers(boardSize, 0);
        numbers2 = new Numbers(boardSize, 0);

        background = new Texture("GameBackground.png");
        mBody.addLast(new Bodypart(15, 15, boardSize)); //head
        mBody.addLast(new Bodypart(15, 14, boardSize));
        mBody.addLast(new Bodypart(15, 13, boardSize)); //tail
    }


    public void update(float delta, Viewport viewport) {
        controls.update(viewport);
        hud.update(delta);
        mTimer += delta;
        if (mTimer > 0.20f) {
            mTimer = 0;
            advance();

        }
    }

    private void advance() {
        float headX = mBody.first().getX();
        float headY = mBody.first().getY();
        switch (controls.getDirection()) {
            case 0: //up
                mBody.addFirst(new Bodypart(headX, headY + 1, boardSize));
                break;
            case 1: //right
                mBody.addFirst(new Bodypart(headX - 1, headY, boardSize));
                break;
            case 2: //down
                mBody.addFirst(new Bodypart(headX, headY - 1, boardSize));
                break;
            case 3: //left
                mBody.addFirst(new Bodypart(headX + 1, headY, boardSize));
                break;
            default://should never happen
                mBody.addFirst(new Bodypart(headX, headY + 1, boardSize));
                break;
        }

            if ( mBody.first().getX() == numbers.getX() && mBody.first().getY() == mBody.first().getY()) {
                Hud.addScore(1);
                Hud.addTime(5);
                numbers = new Numbers(boardSize, NumberQuestion++);
                numbers1 = new Numbers(boardSize, 0);
                numbers2 = new Numbers(boardSize, 0);




            }
            if (mBody.first().getX() == numbers1.getX() && mBody.first().getY() == numbers1.getY() ) {

                Hud.addScore(-1);
                Hud.addTime(-5);
                numbers = new Numbers(boardSize, NumberQuestion++);
                numbers1 = new Numbers(boardSize, 0);
                numbers2 = new Numbers(boardSize, 0);



            }
            if (mBody.first().getX() == numbers2.getX() && mBody.first().getY() == numbers2.getY()) {
                Hud.addScore(-1);
                Hud.addTime(-5);
                numbers = new Numbers(boardSize, NumberQuestion++);
                numbers2 = new Numbers(boardSize, 0);
                numbers1 = new Numbers(boardSize, 0);

            }
            if(NumberQuestion>= 20){
                snakeGame.setScreen(new GameOverScreen(snakeGame, score, sb, viewport));
            }

                mBody.removeLast();



    }

    public void draw(int width, int height, OrthographicCamera camera) {
        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.draw(background, 0, 0, SnakeGame.WIDTH, SnakeGame.HEIGHT);
        sb.end();
        numbers.render();
        numbers1.render();
        numbers2.render();

        sb.setProjectionMatrix(hud.stage.getCamera().combined);

        hud.stage.draw();
        exmaple.stage.draw();


        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        // здесь происходит рисование прямоугольника
        float scaleSnake =  boardSize;

        shapeRenderer.setColor(1, 1, 1, 1);
        for (Bodypart bp : mBody) {
            shapeRenderer.circle(bp.getX() * scaleSnake, bp.getY()*scaleSnake , 25);
        }
        shapeRenderer.end();


    }

    public void dispose() {
        sb.dispose();
        background.dispose();
        shapeRenderer.dispose();


    }


}





