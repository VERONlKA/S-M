package sprites;

import com.badlogic.gdx.math.Vector3;

public class Bodypart {
    private float x;
    private float y;
    private Vector3 position;
    private Controls controls;
    public Bodypart(float x, float y, int boardSize) {
        position = new Vector3(x, y, 0);
        controls = new Controls();
        this.x = x% boardSize;
        if (this.x <0) this.x += boardSize;
        this.y = y% boardSize;
        if (this.y <0) this.y += boardSize;


    }

    public float getX () {
        return x;
    }
    public float getY () {
        return  y;
    }
}

