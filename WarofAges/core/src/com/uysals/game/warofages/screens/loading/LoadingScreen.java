package com.uysals.game.warofages.screens.loading;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uysals.game.warofages.GameConfig;
import com.uysals.game.warofages.WarofAges;
import com.uysals.game.warofages.assets.AssetDescriptors;
import com.uysals.game.warofages.screens.login.LoginScreen;
import com.uysals.game.warofages.utils.GdxUtils;

import java.util.ArrayList;

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

        assetManager.load(AssetDescriptors.FONT24);
        assetManager.load(AssetDescriptors.FONT32);
        assetManager.load(AssetDescriptors.FONT40);
        assetManager.load(AssetDescriptors.FONT48);
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
            GameConfig.disabledFloor = assetManager.get(AssetDescriptors.FLOORS).findRegion("disabledFloor");
            GameConfig.disabledFloor2 = assetManager.get(AssetDescriptors.FLOORS).findRegion("disabledFloor2");
            GameConfig.selectedFloor = assetManager.get(AssetDescriptors.FLOORS).findRegion("selectedFloor");
            GameConfig.buildingMenu = assetManager.get(AssetDescriptors.FLOORS).findRegion("buildingMenu");

            GameConfig.textureRegions = new ArrayList<TextureRegion>();
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("greencastle"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("green1"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("green2"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("green3"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("green4"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("green5"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("green6"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("ice1"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("ice2"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("ice3"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("ice4"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("ice5"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("ice6"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("volcanic1"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("volcanic2"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("volcanic3"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("volcanic4"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("volcanic5"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("volcanic6"));
            GameConfig.textureRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("volcanic7"));

            GameConfig.buildingRegions = new ArrayList<TextureRegion>();
            GameConfig.buildingRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("woodMine"));
            GameConfig.buildingRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("goldMine"));
            GameConfig.buildingRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("stoneMine"));
            GameConfig.buildingRegions.add(assetManager.get(AssetDescriptors.FLOORS).findRegion("coalMine"));


            game.newScreen(new LoginScreen(game));
        }
    }
}
