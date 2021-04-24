package com.uysals.game.warofages.screens.login;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uysals.game.warofages.GameConfig;
import com.uysals.game.warofages.WarofAges;
import com.uysals.game.warofages.screens.mainpage.MainPageScreen;

public class LoginController implements InputProcessor {

    private WarofAges game;

    private static String username = "";
    private static String password = "";
    private static int focuxText = -1;

    private OrthographicCamera camera;
    private Viewport viewport;

    public LoginController(WarofAges game) {
        this.game = game;

        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WIDTH, GameConfig.HEIGHT, camera);

        Gdx.input.setInputProcessor(this);

    }

    public void update(float delta) {

    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public String getUsername(){
        return  username;
    }

    public String getPassword(){
        return  password;
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
        try {
            if(Character.isLetterOrDigit(character)) {
                if(focuxText == 0) {
                    username += character;
                } else if(focuxText == 1) {
                    password += character;
                }
            }
            if(character == 8) {
                if(focuxText == 0) {
                    username = username.substring(0, username.length() - 1);
                } else if(focuxText == 1) {
                    password = password.substring(0, password.length() - 1);
                }
            }
        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
            game.newScreen(new MainPageScreen(game));
        } else if( worldTouch.x >= GameConfig.WIDTH * 0.52f && worldTouch.x <= GameConfig.WIDTH * 0.77f
                && worldTouch.y >= GameConfig.HEIGHT * 0.11f && worldTouch.y <= GameConfig.HEIGHT * 0.21f) {
            System.out.println("SINGUP");
        } else {
            Gdx.input.setOnscreenKeyboardVisible(false);
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println(screenX + "-" + screenY + "-" + pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
