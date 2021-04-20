package com.uysals.game.warofages.screens.login;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uysals.game.warofages.GameConfig;
import com.uysals.game.warofages.assets.AssetDescriptors;
import com.uysals.game.warofages.assets.RegionNames;
import com.uysals.game.warofages.utils.GdxUtils;

public class LoginRenderer implements Disposable {

    private final LoginController controller;
    private  final AssetManager assetManager;
    private  final SpriteBatch batch;

    private TextureRegion loginTable;
    private TextureRegion iconBackDrop;
    private TextureRegion userIcon;
    private TextureRegion passwordIcon;
    private TextureRegion text;
    private TextureRegion loginButton;
    private TextureRegion singupButton;

    private BitmapFont font24;
    private BitmapFont font32;
    private BitmapFont font40;
    private BitmapFont font48;
    private final GlyphLayout layout = new GlyphLayout();

    public LoginRenderer(SpriteBatch batch, AssetManager assetManager, LoginController controller) {
        this.batch = batch;
        this.assetManager = assetManager;
        this.controller = controller;
        init();
    }

    private void init() {

        TextureAtlas guiAtlas = assetManager.get(AssetDescriptors.GUI);

        loginTable = guiAtlas.findRegion(RegionNames.LOGIN_TABLE);
        iconBackDrop = guiAtlas.findRegion(RegionNames.ICONBACKDROP);
        userIcon = guiAtlas.findRegion(RegionNames.USER_ICON);
        passwordIcon = guiAtlas.findRegion(RegionNames.PASSWORD_ICON);
        text = guiAtlas.findRegion(RegionNames.TEXT);
        loginButton = guiAtlas.findRegion(RegionNames.LOGIN_BUTTON);
        singupButton = guiAtlas.findRegion(RegionNames.SINGUP_BUTTON);

        font24 = assetManager.get(AssetDescriptors.FONT24);
        font32 = assetManager.get(AssetDescriptors.FONT32);
        font40 = assetManager.get(AssetDescriptors.FONT40);
        font48 = assetManager.get(AssetDescriptors.FONT48);


        font32.setColor(1f, 1f, 1f, 1f);
        font40.setColor(1f, 1f, 1f, 1f);
        font48.setColor(1f, 1f, 1f, 1f);
    }

    public void render(float delta) {
        GdxUtils.clearScreen();

        controlButton();
        // render gameplay
        renderGamePlay();
    }

    public void controlButton() {
        /*if (Gdx.input.justTouched()) {
            Vector2 screenTouch = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            Vector2 worldTouch = viewport.unproject(new Vector2(screenTouch));

            if( worldTouch.x >= GameConfig.WIDTH * 0.48f && worldTouch.x <= GameConfig.WIDTH * 0.73f
                    && worldTouch.y >= GameConfig.HEIGHT * 0.57f && worldTouch.y <= GameConfig.HEIGHT * 0.64f) {
                focuxText = 0;
                Gdx.input.setOnscreenKeyboardVisible(true);
            } else if( worldTouch.x >= GameConfig.WIDTH * 0.48f && worldTouch.x <= GameConfig.WIDTH * 0.73f
                    && worldTouch.y >= GameConfig.HEIGHT * 0.45f && worldTouch.y <= GameConfig.HEIGHT * 0.52f) {
                focuxText = 1;
                Gdx.input.setOnscreenKeyboardVisible(true);
            } else if( worldTouch.x >= GameConfig.WIDTH * 0.23f && worldTouch.x <= GameConfig.WIDTH * 0.48f
                    && worldTouch.y >= GameConfig.HEIGHT * 0.11f && worldTouch.y <= GameConfig.HEIGHT * 0.21f) {
                System.out.println("LOGIN");
            } else if( worldTouch.x >= GameConfig.WIDTH * 0.52f && worldTouch.x <= GameConfig.WIDTH * 0.77f
                    && worldTouch.y >= GameConfig.HEIGHT * 0.11f && worldTouch.y <= GameConfig.HEIGHT * 0.21f) {
                System.out.println("SINGUP");
            } else {
                Gdx.input.setOnscreenKeyboardVisible(false);
            }

        }*/

    }

    private void renderGamePlay() {
        controller.getViewport().apply();
        batch.setProjectionMatrix(controller.getCamera().combined);
        batch.begin();

        batch.draw(loginTable, GameConfig.WIDTH / 8, GameConfig.HEIGHT / 8, GameConfig.WIDTH * 3 / 4, GameConfig.HEIGHT * 3 / 4);

        layout.setText(font48, "LOGIN");
        font48.draw(batch, "LOGIN", GameConfig.WORLD_CENTER_X - layout.width / 2, GameConfig.HEIGHT * 0.82f);

        layout.setText(font48, "LOGIN");
        font48.draw(batch, "LOGIN", GameConfig.WIDTH * 0.4f - layout.width, GameConfig.HEIGHT * 0.62f);

        batch.draw(iconBackDrop, GameConfig.WIDTH * 0.43f, GameConfig.HEIGHT * 0.57f,
                GameConfig.HEIGHT * 0.07f, GameConfig.HEIGHT * 0.07f);

        batch.draw(userIcon, GameConfig.WIDTH * 0.43f + GameConfig.HEIGHT * 0.015f, GameConfig.HEIGHT * 0.585f,
                GameConfig.HEIGHT * 0.04f, GameConfig.HEIGHT * 0.04f);

        batch.draw(text, GameConfig.WIDTH * 0.48f , GameConfig.HEIGHT * 0.57f,
                GameConfig.WIDTH * 0.3f, GameConfig.HEIGHT * 0.07f);

        if( controller.getUsername().equals("")) {
            font40.setColor(0.93f, 0.93f, 0.93f, 0.93f);
            layout.setText(font40, "USERNAME");
            font40.draw(batch, "USERNAME", GameConfig.WIDTH * 0.63f - layout.width / 2, GameConfig.HEIGHT * 0.62f);
            font40.setColor(Color.WHITE);
        } else {
            layout.setText(font40, controller.getUsername());
            font40.draw(batch, controller.getUsername(), GameConfig.WIDTH * 0.63f - layout.width / 2, GameConfig.HEIGHT * 0.62f);
        }

        layout.setText(font48, "PASSWORD");
        font48.draw(batch, "PASSWORD", GameConfig.WIDTH * 0.4f - layout.width, GameConfig.HEIGHT * 0.5f);

        batch.draw(iconBackDrop, GameConfig.WIDTH * 0.43f, GameConfig.HEIGHT * 0.45f,
                GameConfig.HEIGHT * 0.07f, GameConfig.HEIGHT * 0.07f);

        batch.draw(passwordIcon, GameConfig.WIDTH * 0.43f + GameConfig.HEIGHT * 0.015f, GameConfig.HEIGHT * 0.465f,
                GameConfig.HEIGHT * 0.04f, GameConfig.HEIGHT * 0.04f);

        batch.draw(text, GameConfig.WIDTH * 0.48f , GameConfig.HEIGHT * 0.45f,
                GameConfig.WIDTH * 0.3f, GameConfig.HEIGHT * 0.07f);

        if( controller.getPassword().equals("")) {
            font40.setColor(0.93f, 0.93f, 0.93f, 0.93f);
            layout.setText(font40, "PASSWORD");
            font40.draw(batch, "PASSWORD", GameConfig.WIDTH * 0.63f - layout.width / 2, GameConfig.HEIGHT * 0.5f);
            font40.setColor(Color.WHITE);
        } else {
            /*String temp = "";
            for(int i = 0; i < password.length(); i++)
                temp += "*";*/
            layout.setText(font40, controller.getPassword());
            font40.draw(batch, controller.getPassword(), GameConfig.WIDTH * 0.63f - layout.width / 2, GameConfig.HEIGHT * 0.5f);
        }

        batch.draw(loginButton, GameConfig.WIDTH * 0.23f , GameConfig.HEIGHT * 0.11f,
                GameConfig.WIDTH * 0.25f, GameConfig.HEIGHT * 0.1f);

        layout.setText(font48, "LOGIN");
        font48.draw(batch, "LOGIN", GameConfig.WIDTH * 0.355f - layout.width / 2, GameConfig.HEIGHT * 0.18f);

        batch.draw(singupButton, GameConfig.WIDTH * 0.52f , GameConfig.HEIGHT * 0.11f,
                GameConfig.WIDTH * 0.25f, GameConfig.HEIGHT * 0.1f);

        layout.setText(font48, "SING UP");
        font48.draw(batch, "SING UP", GameConfig.WIDTH * 0.645f - layout.width / 2, GameConfig.HEIGHT * 0.18f);

        batch.end();
    }

    public void resize(int width, int height) {
        controller.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
//		renderer.dispose();
    }
}
