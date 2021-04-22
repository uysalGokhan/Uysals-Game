package com.uysals.game.warofages.screens.mainpage;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.uysals.game.warofages.WarofAges;
import com.uysals.game.warofages.screens.login.LoginController;
import com.uysals.game.warofages.screens.login.LoginRenderer;

public class MainPageScreen implements Screen {

    private final WarofAges game;
    private final AssetManager assetManager;

    private MainPageController controller;
    private MainPageRenderer renderer;

    public MainPageScreen(WarofAges game) {
        this.game = game;
        this.assetManager = game.getAssetManager();
    }

    @Override
    public void show() {
        controller = new MainPageController(game);
        renderer = new MainPageRenderer(game.getBatch(), assetManager, controller);
    }

    @Override
    public void render(float delta) {
        controller.update(delta);
        renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        renderer.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
