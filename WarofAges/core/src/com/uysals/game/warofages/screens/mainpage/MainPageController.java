package com.uysals.game.warofages.screens.mainpage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uysals.game.warofages.GameConfig;
import com.uysals.game.warofages.WarofAges;
import com.uysals.game.warofages.assets.AssetDescriptors;
import com.uysals.game.warofages.objects.Floor;

import java.util.ArrayList;

public class MainPageController implements InputProcessor {

    private WarofAges game;
    private  final AssetManager assetManager;

    private OrthographicCamera camera;
    private Viewport viewport;

    private ArrayList<Floor> floors;

    private Vector2 lastTouch = new Vector2();

    private int selectedFloor = -1;

    public MainPageController(WarofAges game) {
        this.game = game;
        this.assetManager = game.getAssetManager();

        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WIDTH, GameConfig.HEIGHT, camera);

        floors = new ArrayList<Floor>();

        TextureAtlas floorAtlas = assetManager.get(AssetDescriptors.FLOORS);

        floors.add(new Floor(GameConfig.WORLD_CENTER_X - 200f, GameConfig.WORLD_CENTER_Y, floorAtlas.findRegion("green1")));
        floors.add(new Floor(GameConfig.WORLD_CENTER_X, GameConfig.WORLD_CENTER_Y, floorAtlas.findRegion("green2")));
        floors.add(new Floor(GameConfig.WORLD_CENTER_X + 200f, GameConfig.WORLD_CENTER_Y, floorAtlas.findRegion("green3")));
        floors.add(new Floor(GameConfig.WORLD_CENTER_X - 100f, GameConfig.WORLD_CENTER_Y - 180f, floorAtlas.findRegion("green4")));
        floors.add(new Floor(GameConfig.WORLD_CENTER_X + 100f, GameConfig.WORLD_CENTER_Y - 180f, floorAtlas.findRegion("green5")));

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

    public ArrayList<Floor> getFloors() {
        return floors;
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
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        lastTouch.set(screenX, screenY);
        Vector2 worldTouch = viewport.unproject(new Vector2(lastTouch));
        selectedFloor = -1;
        for(int i = 0; i < floors.size(); i++) {
            if(distance(worldTouch, new Vector2(floors.get(i).xCoor, floors.get(i).yCoor)) < 186f) {
                selectedFloor = i;
                System.out.println(i);
                break;
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector2 newTouch = new Vector2(screenX, screenY);
        // delta will now hold the difference between the last and the current touch positions
        // delta.x > 0 means the touch moved to the right, delta.x < 0 means a move to the left
        Vector2 delta = newTouch.cpy().sub(lastTouch);
        lastTouch = newTouch;
        camera.translate(-delta.x, delta.y);
        selectedFloor = -1;
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

    private double distance(Vector2 object1, Vector2 object2){
        return Math.sqrt(Math.pow((object2.x - object1.x), 2) + Math.pow((object2.y - object1.y), 2));
    }
}
