package com.uysals.game.warofages.screens.mainpage;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.uysals.game.warofages.GameConfig;
import com.uysals.game.warofages.assets.AssetDescriptors;
import com.uysals.game.warofages.objects.Floor;
import com.uysals.game.warofages.utils.GdxUtils;

import java.util.ArrayList;

public class MainPageRenderer implements Disposable {

    private final MainPageController controller;
    private  final AssetManager assetManager;
    private  final SpriteBatch batch;

    private BitmapFont font32;
    private final GlyphLayout layout = new GlyphLayout();

    public MainPageRenderer(SpriteBatch batch, AssetManager assetManager, MainPageController controller) {
        this.batch = batch;
        this.assetManager = assetManager;
        this.controller = controller;
        init();
    }

    public void init() {
        font32 = assetManager.get(AssetDescriptors.FONT32);

        font32.setColor(0f, 0f, 0f, 1f);
    }

    public void render(float delta) {
        GdxUtils.clearScreen();
        // render gameplay
        renderGamePlay();

        renderMenu();
    }

    private void renderGamePlay() {
        controller.getViewport().apply();
        batch.setProjectionMatrix(controller.getCamera().combined);
        batch.begin();

        ArrayList<Floor> floors = controller.getFloors();

        for(int i = 0; i < floors.size(); i++) {
            floors.get(i).draw(batch);
        }

        batch.end();
    }

    private void renderMenu() {
        controller.getMenuViewport().apply();
        batch.setProjectionMatrix(controller.getMenuCamera().combined);
        batch.begin();

        layout.setText(font32, "MENU CAMERA");
        font32.draw(batch, "MENU CAMERA", GameConfig.WIDTH * 0.9f - layout.width, GameConfig.HEIGHT * 0.95f);

        batch.end();
    }

    public void resize(int width, int height) {
        controller.getViewport().update(width, height, true);
        controller.getMenuViewport().update(width, height, true);
    }

    @Override
    public void dispose() {

    }
}
