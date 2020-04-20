package game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Queue;
import com.badlogic.gdx.utils.viewport.Viewport;

import sprites.Bodypart;
import sprites.Controls;
import sprites.Food;

public class GameState {
    private float mTimer = 0;
    public static final int width = 480;
    public static final int height = 800;
    private int boardSize = 30;
    private int yOffset = 1;
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Queue<Bodypart> mBody = new Queue<>();
    private  Texture background;
    private SpriteBatch sb;
    private Food mFood = new Food(boardSize);
    private Controls controls = new Controls();
    private Vector3 touch = new Vector3();
    private OrthographicCamera camera = new OrthographicCamera(width, height);


    public GameState() {
        sb = new SpriteBatch();
        camera.setToOrtho(false, width, height);
        background = new Texture("background.png");
        mBody.addLast(new Bodypart(15,15,boardSize)); //head
        mBody.addLast(new Bodypart(15,14,boardSize));
        mBody.addLast(new Bodypart(15,13,boardSize)); //tail

    }


    public void update(float delta, Viewport viewport){
        controls.update (viewport);
        mTimer += delta;
        if (mTimer > 0.13f) {
            mTimer = 0;
            advance();

        }
    }
    private void advance() {
        int headX = mBody.first().getX();
        int headY = mBody.first().getY();
        switch(controls.getDirection()) {
            case 0: //up
                mBody.addFirst(new Bodypart(headX, headY+1, boardSize));
                break;
            case 1: //right
                mBody.addFirst(new Bodypart(headX+1, headY, boardSize));
                break;
            case 2: //down
                mBody.addFirst(new Bodypart(headX, headY-1, boardSize));
                break;
            case 3: //left
                mBody.addFirst(new Bodypart(headX-1, headY, boardSize));
                break;
            default://should never happen
                mBody.addFirst(new Bodypart(headX, headY+1, boardSize));
                break;
        }
        mBody.removeLast();
    }


    public void draw(int width, int height, OrthographicCamera camera){
        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.draw(background, 0, 0, width, height);

        sb.end();
        shapeRenderer.setProjectionMatrix (camera.combined);
        shapeRenderer.begin (ShapeRenderer.ShapeType.Filled);
// здесь происходит рисование прямоугольника
        float scaleSnake = boardSize ;
        shapeRenderer.setColor (1,1,1,1);
        for (Bodypart bp: mBody) {
            shapeRenderer.circle (bp.getX () * scaleSnake  , bp.getY () * scaleSnake  , 25);
        }
        shapeRenderer.end ();



        }

    }

