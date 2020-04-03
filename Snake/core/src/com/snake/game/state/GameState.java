package com.snake.game.state;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.snake.game.SnakeGame;

public class GameState extends State {
    private Texture Background;
    private Texture snakeBody;
    public GameState(GameStateManager gsm) {
        super(gsm);
        Background = new Texture("backround.png");
        snakeBody = new Texture("BodySnake.png");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
sb.begin();
sb.draw(Background, 0, 0, SnakeGame.WIDTH, SnakeGame.HEGHT);
sb.draw(snakeBody,64,64);
sb.end();
    }

    @Override
    public void dispose() {
 Background.dispose();
    }
}
