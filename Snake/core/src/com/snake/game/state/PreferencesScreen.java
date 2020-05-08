package com.snake.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;

import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.snake.game.SnakeGame;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Preferences;


import java.awt.Checkbox;

public class PreferencesScreen implements Screen, InputProcessor {

    private SnakeGame snakeGame;
    private Stage stage;
    private OrthographicCamera camera = new OrthographicCamera(SnakeGame.WIDTH, SnakeGame.HEIGHT);
    private Texture background;
    private Label titleLabel, volumeMusicLabel, volumeSoundLabel, musicOnOffLabel, soundOnOffLabel;
    private Slider soundMusicSlider, volumeMusicSlider;
    private Checkbox soundEffectsCheckbox;
    private Button backButton;
    private Preferences prefs;
    private SpriteBatch batch;


    public PreferencesScreen(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Preferences prefs = Gdx.app.getPreferences("settings.prefs");
        camera.setToOrtho(false, SnakeGame.WIDTH, SnakeGame.HEIGHT);
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));



        final Slider volumeMusicSlider = new Slider(0f, 1f, 0.1f, false, skin);
        volumeMusicSlider.setValue(this.snakeGame.getPreferences().getMusicVolume());
        volumeMusicSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                return false;
            }
        });
        final CheckBox musicCheckbox = new CheckBox(null, skin);
        musicCheckbox.setChecked( this.snakeGame.getPreferences().isMusicEnabled() );
        musicCheckbox.addListener( new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = musicCheckbox.isChecked();
                PreferencesScreen.this.snakeGame.getPreferences().setMusicEnabled( enabled );
                return false;
            }
        });
        final Slider soundMusicSlider = new Slider(0f, 1f, 0.1f, false, skin) ;
        soundMusicSlider.setValue(this.snakeGame.getPreferences().getSoundVolume());
        soundMusicSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                return false;
            }
        });
        final CheckBox soundEffectsCheckbox = new CheckBox(null, skin);
        soundEffectsCheckbox.setChecked(this.snakeGame.getPreferences().isSoundEffectsEnabled());
        soundEffectsCheckbox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                return false;
            }
        });

        titleLabel = new Label( "Preferences", skin );
        volumeMusicLabel = new Label( null, skin );
        volumeSoundLabel = new Label( null, skin );
        musicOnOffLabel = new Label( null, skin );
        soundOnOffLabel = new Label( null, skin );

        table.add(titleLabel);
        table.row();
        table.add(volumeMusicLabel);
        table.add(volumeMusicSlider);
        table.row();
        table.add(musicOnOffLabel);
        table.add(musicCheckbox);
        table.row();
        table.add(volumeSoundLabel);
        table.add(soundMusicSlider);
        table.row();
        table.add(soundOnOffLabel);
        table.add(soundEffectsCheckbox);
        table.row();
        table.add(backButton);
        //  stage.clear();

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        //   batch.setProjectionMatrix(camera.combined);
        // clear the screen ready for next set of images to be drawn
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
