package sprites;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Numbers implements ApplicationListener {
    private Texture texture;
    private SpriteBatch sb;
    private TextureRegion[] regions = new TextureRegion[4];
    private Rectangle [] rectangles = new Rectangle[4];
    private  int x = MathUtils.random(128, 352);
    private  int y = MathUtils.random(128, 672);


    @Override
    public void create() {

        texture = new Texture(Gdx.files.internal("foods-sheeps.png"));
        sb = new SpriteBatch();
        regions[0] = new TextureRegion(texture, 0, 0, 64, 64);		// #3
        regions[1] = new TextureRegion(texture, 0.5f, 0f, 1f, 0.5f);	// #4
        regions[2] = new TextureRegion(texture, 0, 63, 64, 64);		// #5
        regions[3] = new TextureRegion(texture, 0.5f, 0.5f, 1f, 1f);
        rectangles[0] = new Rectangle(regions[0].getRegionX(), regions[0].getRegionY(), regions[0].getRegionWidth(), regions[0].getRegionHeight());
        rectangles[1] = new Rectangle(regions[1].getRegionX(), regions[1].getRegionY(), regions[1].getRegionWidth(), regions[1].getRegionHeight());
        rectangles[2] = new Rectangle(regions[2].getRegionX(), regions[2].getRegionY(), regions[2].getRegionWidth(), regions[2].getRegionHeight());
        rectangles[3] = new Rectangle(regions[3].getRegionX(), regions[3].getRegionY(), regions[3].getRegionWidth(), regions[3].getRegionHeight());
        this.render();
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void resize(int width, int height) {

    }

    public Texture getTexture() {
        return texture;
    }

    @Override
    public void render() {
        sb.begin();
        for (int i = 0; i < 1; i++) {

            sb.draw(regions[i], this.getX(), this.getY());
        }
        sb.end();

    }
    public Rectangle getBounds(){
        return rectangles[0];
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
 sb.dispose();
 texture.dispose();

    }
}
