package com.snake.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake.game.SnakeGame;

public class MenuState extends State {
    private Texture backgroundMenu;
    private Texture logoSnake;

    private Texture settingsBtn;

    private Texture playBtn;
    private Sprite playSprite;
    private SpriteBatch batch;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        backgroundMenu = new Texture("menuBackGR.jpg");
        logoSnake = new Texture("logoSnake.PNG");
        settingsBtn = new Texture("settingsButton.PNG");
        camera.setToOrtho(false, SnakeGame.WIDTH , SnakeGame.HEGHT);
        create();

    }

    @Override
    protected void handleInput() {

        if (Gdx.input.isTouched()) {
            if (playSprite.getBoundingRectangle().contains(Gdx.input.getX(), Gdx.graphics.getHeight()-Gdx.input.getY())) {
                gsm.push(new ChooseAnAction(gsm));
                dispose();
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    public void create(){
        playBtn = new Texture("playButton.png");
        batch = new SpriteBatch();
        playSprite=new Sprite(playBtn, 0,0, 100,100);
        playSprite.setSize(105,105);
        playSprite.setPosition(190, 140);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(backgroundMenu, 0,0, SnakeGame.WIDTH, SnakeGame.HEGHT);
        sb.draw(playBtn, 190, 140, 105,105  );
        sb.draw(logoSnake, 95, 245, 290,290);
        sb.draw(settingsBtn, 370,700, 45,45);

        batch.begin();
        playSprite.draw(batch);
        batch.end();

        sb.end();

    }

    @Override
    public void dispose() {
        backgroundMenu.dispose();
        playBtn.dispose();
        logoSnake.dispose();
        settingsBtn.dispose();
    }
}
