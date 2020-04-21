package com.snake.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.snake.game.SnakeGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = SnakeGame.WIDTH;
		config.height = SnakeGame.HEIGHT;
		config.title = SnakeGame.TITLE;

		new LwjglApplication( new SnakeGame(), config);

	}
}
