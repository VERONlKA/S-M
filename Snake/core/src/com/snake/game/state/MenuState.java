package com.snake.game.state;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake.game.SnakeGame;

public class MenuState extends State {
    private Texture backgroundMenu;
    private Texture playBtn;
    private Texture logoSnake;
    private Texture settingsBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        backgroundMenu = new Texture("menuBackGR.jpg");
        playBtn = new Texture("playButton.png");
        logoSnake = new Texture("logoSnake.PNG");
        settingsBtn = new Texture("settingsButton.PNG");
        camera.setToOrtho(false, SnakeGame.WIDTH , SnakeGame.HEGHT);

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(backgroundMenu, 0,0, SnakeGame.WIDTH, SnakeGame.HEGHT);
        sb.draw(playBtn, 190, 120, 100,100  );
        sb.draw(logoSnake, 60, 260, 370,370);
        sb.draw(settingsBtn, 370,700, 45,45);

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
