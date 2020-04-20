package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Food {
    private int x;
    private int y;
    private Texture four;
    public Food(int boardSize){
        randomisePos(boardSize);
        four = new Texture("four.png");

    }
    public void randomisePos(int boardSize){
        x = MathUtils.random(boardSize-1);
        y = MathUtils.random(boardSize-1);
    }

    public Texture getFour() {
        return four;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
