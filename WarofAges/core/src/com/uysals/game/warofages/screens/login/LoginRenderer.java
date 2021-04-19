package com.uysals.game.warofages.screens.login;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uysals.game.warofages.GameConfig;
import com.uysals.game.warofages.utils.GdxUtils;

public class LoginRenderer implements Disposable {

    private final LoginController controller;
    private  final AssetManager assetManager;
    private  final SpriteBatch batch;

    private OrthographicCamera camera;
    private Viewport viewport;

    public LoginRenderer(SpriteBatch batch, AssetManager assetManager, LoginController controller) {
        this.batch = batch;
        this.assetManager = assetManager;
        this.controller = controller;
        init();
    }

    private void init() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WIDTH, GameConfig.HEIGHT, camera);
    }

    public void render(float delta) {
        GdxUtils.clearScreen(Color.BLUE);

        controlButton();
        // render gameplay
        renderGamePlay();
    }

    public void controlButton() {

    }

    private void renderGamePlay() {
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.end();
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
//		renderer.dispose();
    }
}
