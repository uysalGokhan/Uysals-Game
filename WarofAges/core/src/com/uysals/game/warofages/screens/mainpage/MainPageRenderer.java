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

        //layout.setText(font32, "MENU CAMERA");
        //font32.draw(batch, "MENU CAMERA", controller.getMenuViewport().getWorldWidth() * 0.9f - layout.width, controller.getMenuViewport().getWorldHeight() * 0.95f);

        float[] resources = controller.getResources();



        for(int i = 0; i < 4; i++) {
            batch.draw(GameConfig.buildingMenu, controller.getMenuViewport().getWorldWidth() * 0.25f * i, controller.getMenuViewport().getWorldHeight() * 0.90f,
                    controller.getMenuViewport().getWorldWidth() * 0.25f, controller.getMenuViewport().getWorldHeight() * 0.1f);

            batch.draw(GameConfig.resourcesAssets[i], controller.getMenuViewport().getWorldWidth() * 0.25f * i + 100f,
                    controller.getMenuViewport().getWorldHeight() * 0.90f + controller.getMenuViewport().getWorldHeight() * 0.05f - 30f,
                    60f, 60f);

            //layout.setText(font32, resources[i] + "");
            font32.draw(batch, String.format("%.2f", resources[i]), controller.getMenuViewport().getWorldWidth() * 0.25f * i + 200f,
                    controller.getMenuViewport().getWorldHeight() * 0.90f + controller.getMenuViewport().getWorldHeight() * 0.05f);

        }

        if(controller.getSelectedFloor() != -1) {
            ArrayList<Floor> floors = controller.getFloors();
            floors.get(controller.getSelectedFloor()).drawMenu(batch);
        }

        batch.end();
    }

    public void resize(int width, int height) {
        controller.getViewport().update(width, height, true);
        controller.getCamera().position.set(0f, 0f, 0f);
        controller.getMenuViewport().update(width, height, true);
        GameConfig.menuViewPortWith = controller.getMenuViewport().getWorldWidth();
        GameConfig.menuViewPortHeight = controller.getMenuViewport().getWorldHeight();
    }

    @Override
    public void dispose() {

    }
}
