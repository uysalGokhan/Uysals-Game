package com.uysals.game.warofages.screens.loading;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uysals.game.warofages.WarofAges;

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

    }

    @Override
    public void render(float delta) {

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

        assetManager.update();
    }
}
