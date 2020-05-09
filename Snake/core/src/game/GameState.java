package game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Queue;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.snake.game.SnakeGame;

import sprites.Bodypart;
import sprites.Controls;
import sprites.Numbers;

public class GameState {
    private int x;
    private int y;
    private float mTimer = 0;

    private int boardSize = 30;
    private int yOffset = 1;
    private Numbers numbers;
    private Numbers numbers1;
    private Numbers numbers2;
    private Hud hud;


    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Queue<Bodypart> mBody = new Queue<>();
    private Texture background;
    private SpriteBatch sb;
    private Controls controls = new Controls();

    private Viewport viewport;
    private OrthographicCamera camera = new OrthographicCamera(SnakeGame.WIDTH, SnakeGame.HEIGHT);

    private int snakeLength = 3;


    public GameState() {
        sb = new SpriteBatch();
        hud = new Hud(sb, viewport);

        numbers = new Numbers();
        numbers1 = new Numbers();
        numbers2 = new Numbers();
        camera.setToOrtho(false, SnakeGame.WIDTH, SnakeGame.HEIGHT);


        background = new Texture("background.png");
        mBody.addLast(new Bodypart(15, 15, boardSize)); //head
        mBody.addLast(new Bodypart(15, 14, boardSize));
        mBody.addLast(new Bodypart(15, 13, boardSize)); //tail


    }


    public void update(float delta, Viewport viewport) {
        controls.update(viewport);
        hud.update(delta);
        mTimer += delta;
        if (mTimer > 0.13f) {
            mTimer = 0;
            advance();

        }
    }

    private void advance() {
        int headX = mBody.first().getX();
        int headY = mBody.first().getY();
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
        if (mBody.first().getX() == numbers.getX() && mBody.first().getY() == numbers.getY()) {
            snakeLength++;
            Hud.addScore(1);

        }
        if (mBody.size - 1 == snakeLength) {
        mBody.removeLast();}
    }


    public void draw(int width, int height, OrthographicCamera camera) {
        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.draw(background, 0, 0, SnakeGame.WIDTH, SnakeGame.HEIGHT);
        sb.end();

        numbers.create();
        numbers1.create();
        numbers2.create();
        sb.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        // здесь происходит рисование прямоугольника
        float scaleSnake = boardSize;
        shapeRenderer.setColor(1, 1, 1, 1);
        for (Bodypart bp : mBody) {
            shapeRenderer.circle(bp.getX()*scaleSnake , bp.getY()*scaleSnake , 25);
        }
        shapeRenderer.end();

    }







}





