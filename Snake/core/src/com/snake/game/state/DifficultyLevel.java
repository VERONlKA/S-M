package com.snake.game.state;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake.game.SnakeGame;

public class DifficultyLevel extends State{

    private Texture background;
    private Texture easy;
    private Texture medium;
    private Texture hard;
    private Texture back;

    public DifficultyLevel(GameStateManager gsm) {
        super(gsm);
        background = new Texture("forestBG.jpg");
        easy = new Texture("easy.PNG");
        medium = new Texture("medium.PNG");
        hard = new Texture("hard.PNG");
        back = new Texture("return.PNG");
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
        sb.draw(background, 0,0, SnakeGame.WIDTH, SnakeGame.HEGHT);
        sb.draw(back, 79,700, 60,60);
        sb.draw(easy, 70,350, 330, 330);
        sb.draw(medium, 70, 210, 330,330);
        sb.draw(hard, 70, 70, 330,330);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
