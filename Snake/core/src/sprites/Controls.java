package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.snake.game.SnakeGame;

public class Controls {
    private Vector2 touch = new Vector2();
    private OrthographicCamera camera = new OrthographicCamera();
    private int currentDirection = 0; // 0,1,2,3 U, R, D, L
    private int nextDirection = 0;

    public int getDirection () {
        currentDirection = nextDirection;
        return nextDirection;}
        public void update (Viewport viewport) {
        if(Gdx.input.justTouched()){
            touch.x = Gdx.input.getX ();
            touch.y = Gdx.input.getY ();
            viewport.unproject (touch);
        }
        if  ((Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.justTouched()  && touch.x < SnakeGame.WIDTH/2f && touch.x > 0 && currentDirection!= 2)) { nextDirection = 0;}

        else if (Gdx.input.isKeyPressed (Input.Keys.LEFT)||Gdx.input.justTouched()   && touch.x < SnakeGame.WIDTH/3f && touch.x > 0 && currentDirection!= 3){ nextDirection = 1;}

        else if (Gdx.input.isKeyPressed (Input.Keys.DOWN) || Gdx.input.justTouched()  && touch.x < SnakeGame.WIDTH/0f && touch.x > 0 && currentDirection!= 0){ nextDirection = 2;}

        else if (Gdx.input.isKeyPressed (Input.Keys.RIGHT)||Gdx.input.justTouched()  && touch.x < SnakeGame.WIDTH/1f && touch.x > 0 && currentDirection!= 1){ nextDirection = 3;}

}
}