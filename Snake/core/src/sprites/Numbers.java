package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.snake.game.SnakeGame;

import game.Hud;

import static game.GameState.boardSize;
import static game.GameState.scaleSnake;


public class Numbers {
    private int x;
    private int y;

    private Texture texture;
    private Texture texture1;
    private Texture texture2;
    private Texture texture3;
    private Texture texture4;
    private SpriteBatch batch;
    private OrthographicCamera camera = new OrthographicCamera(SnakeGame.WIDTH, SnakeGame.HEIGHT);
    int NumberQuestion = 0;

    private TextureRegion[] regions = new TextureRegion[20];
    private TextureRegion region ;
    public Numbers(int boardSize, int NumberQuestion){
        x = MathUtils.random(boardSize-16);
        y = MathUtils.random(boardSize-16);
        camera.setToOrtho(false, SnakeGame.WIDTH, SnakeGame.HEIGHT);
        texture = new Texture(Gdx.files.internal("foods-sheeps.png"));
        texture2 = new Texture(Gdx.files.internal("nine_twelve.png"));
        texture3 = new Texture(Gdx.files.internal("fifteen_twenty.png"));
        texture1 = new Texture(Gdx.files.internal("five_eight.png"));
        texture4 = new Texture(Gdx.files.internal("twentyone_twentyseven.png"));
        batch = new SpriteBatch();
        regions[0] = new TextureRegion(texture, 0, 0, 64, 64);		// #3
        regions[1] = new TextureRegion(texture, 0.5f, 0f, 1f, 0.5f);	// #4
        regions[2] = new TextureRegion(texture, 0, 63, 64, 64);		// #5
        regions[3] = new TextureRegion(texture, 0.5f, 0.5f, 1f, 1f);
        regions[4] = new TextureRegion(texture1, 0, 0, 64, 64);		// #3
        regions[5] = new TextureRegion(texture1, 0.5f, 0f, 1f, 0.5f);	// #4
        regions[6] = new TextureRegion(texture1, 0, 62, 64, 64);		// #5
        regions[7] = new TextureRegion(texture1, 0.5f, 0.5f, 1f, 1f);
        regions[8] = new TextureRegion(texture2, 0, 0, 64, 64);		// #3
        regions[9] = new TextureRegion(texture2, 0.5f, 0f, 1f, 0.5f);	// #4
        regions[10] = new TextureRegion(texture2, 0, 63, 64, 64);		// #5
        regions[11] = new TextureRegion(texture2, 0.5f, 0.5f, 1f, 1f);
        regions[12] = new TextureRegion(texture3, 0, 0, 64, 64);		// #3
        regions[13] = new TextureRegion(texture3, 0.5f, 0f, 1f, 0.5f);	// #4
        regions[14] = new TextureRegion(texture3, 0, 63, 64, 64);		// #5
        regions[15] = new TextureRegion(texture3, 0.5f, 0.5f, 1f, 1f);
        regions[16] = new TextureRegion(texture4, 0, 0, 64, 64);		// #3
        regions[17] = new TextureRegion(texture4, 0.5f, 0f, 1f, 0.5f);	// #4
        regions[18] = new TextureRegion(texture4, 0, 63, 64, 64);		// #5
        regions[19] = new TextureRegion(texture4, 0.5f, 0.5f, 1f, 1f);

        if(NumberQuestion == 0){

        region = (regions[(int) MathUtils.random(2, regions.length-1)]);}
        if(NumberQuestion == 1){
            region = regions[0];
            Exmaple.example[0].setText("1*1");
        }
          if(NumberQuestion == 2){
            region = regions[5];
              Exmaple.example[0].setText("3*2");
          }
        if(NumberQuestion == 3){
            region = regions[9];
            Exmaple.example[0].setText("2*5");
        }
        if(NumberQuestion == 4){
            region = regions[1];
            Exmaple.example[0].setText("1*2");
        }
        if(NumberQuestion == 5){
            region = regions[14];
            Exmaple.example[0].setText("3*6");
        }
        if(NumberQuestion == 6){
            region = regions[3];
            Exmaple.example[0].setText("2*2");
        }
        if(NumberQuestion == 7){
            region = regions[17];
            Exmaple.example[0].setText("3*8");
        }
        if(NumberQuestion == 8){
            region = regions[4];
            Exmaple.example[0].setText("1*5");
        }
        if(NumberQuestion == 9){
            region = regions[11];
            Exmaple.example[0].setText("2*7");
        }
        if(NumberQuestion == 10){
            region = regions[10];
            Exmaple.example[0].setText("3*4");
        }
        if(NumberQuestion == 11){
            region = regions[14];
            Exmaple.example[0].setText("2*9");
        }
        if(NumberQuestion == 12){
            region = regions[8];
            Exmaple.example[0].setText("1*9");
        }
        if(NumberQuestion == 13){
            region = regions[3];
            Exmaple.example[0].setText("1*4");
        }
        if(NumberQuestion == 14){
            region = regions[12];
            Exmaple.example[0].setText("3*5");
        }
        if(NumberQuestion == 15){
            region = regions[7];
            Exmaple.example[0].setText("2*4");
        }
        if(NumberQuestion == 16){
            region = regions[5];
            Exmaple.example[0].setText("1*6");
        }
        if(NumberQuestion == 17){
            region = regions[16];
            Exmaple.example[0].setText("3*7");
        }
        if(NumberQuestion == 18){
            region = regions[10];
            Exmaple.example[0].setText("2*6");
        }
        if(NumberQuestion == 19){
            region = regions[5];
            Exmaple.example[0].setText("1*6");
        }
        if(NumberQuestion == 20){
            region = regions[7];
            Exmaple.example[0].setText("1*8");
        }


        }


    public Texture getTexture() {
        return texture;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void render (){
        batch.setProjectionMatrix(camera.combined);
    batch.begin();

        batch.draw(region,getX()*scaleSnake, getY()*scaleSnake);

    batch.end();

}
 public  void advance(){
        if(NumberQuestion == 0){
            batch.begin();
            batch.draw(regions[0], getX()*scaleSnake, getY()*scaleSnake);
            batch.end();
        }

 }
    public void dispose(){
        batch.dispose();
        texture.dispose();

    }
}