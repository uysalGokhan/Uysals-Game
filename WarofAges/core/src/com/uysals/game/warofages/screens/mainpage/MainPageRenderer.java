package com.uysals.game.warofages.screens.mainpage;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.uysals.game.warofages.utils.GdxUtils;

public class MainPageRenderer implements Disposable {

    private final MainPageController controller;
    private  final AssetManager assetManager;
    private  final SpriteBatch batch;

    public MainPageRenderer(SpriteBatch batch, AssetManager assetManager, MainPageController controller) {
        this.batch = batch;
        this.assetManager = assetManager;
        this.controller = controller;
        init();
    }

    public void init() {

    }

    public void render(float delta) {
        GdxUtils.clearScreen(Color.BROWN);
        // render gameplay
        renderGamePlay();
    }

    private void renderGamePlay() {

    }

    public void resize(int width, int height) {
        controller.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {

    }
}
