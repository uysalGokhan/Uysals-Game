package com.uysals.game.warofages.screens.loading;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uysals.game.warofages.GameConfig;
import com.uysals.game.warofages.WarofAges;
import com.uysals.game.warofages.assets.AssetDescriptors;
import com.uysals.game.warofages.screens.login.LoginScreen;
import com.uysals.game.warofages.utils.GdxUtils;

public class LoadingScreen extends ScreenAdapter {

    private final WarofAges game;
    private final AssetManager assetManager;

    private OrthographicCamera camera;
    private Viewport viewport;

    private float progress;

    public LoadingScreen(WarofAges game) {
        this.game = game;
        this.assetManager = game.getAssetManager();
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WIDTH, GameConfig.HEIGHT, camera);

        assetManager.load(AssetDescriptors.FLOORS);
        assetManager.load(AssetDescriptors.GUI);
    }

    @Override
    public void render(float delta) {
        update(delta);

        GdxUtils.clearScreen();
        viewport.apply();

        game.getBatch().setProjectionMatrix(camera.combined);
        game.getBatch().begin();
        game.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {

    }

    private void update(float delta) {
        progress = assetManager.getProgress();

        if(assetManager.update()) {
            game.newScreen(new LoginScreen(game));
        }
    }
}
