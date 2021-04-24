package com.uysals.game.warofages.screens.mainpage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uysals.game.warofages.GameConfig;
import com.uysals.game.warofages.WarofAges;
import com.uysals.game.warofages.assets.AssetDescriptors;
import com.uysals.game.warofages.objects.Floor;

import java.util.ArrayList;
import java.util.List;

public class MainPageController implements GestureDetector.GestureListener {

    private WarofAges game;
    private  final AssetManager assetManager;

    private OrthographicCamera camera;
    private Viewport viewport;

    private OrthographicCamera menuCamera;
    private Viewport menuViewport;

    private ArrayList<Floor> floors;

    private Vector2 lastTouch = new Vector2();

    private int selectedFloor = -1;

    public MainPageController(WarofAges game) {
        this.game = game;
        this.assetManager = game.getAssetManager();

        camera = new OrthographicCamera();
        viewport = new ExtendViewport(GameConfig.WIDTH, GameConfig.HEIGHT, camera);

        menuCamera = new OrthographicCamera();
        menuViewport = new ExtendViewport(GameConfig.WIDTH, GameConfig.HEIGHT, menuCamera);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileHandle file = Gdx.files.internal("defaultMap.json");
        String text = file.readString();
        floors = gson.fromJson(text, new TypeToken<List<Floor>>(){}.getType());

        Gdx.input.setInputProcessor(new GestureDetector(this));

    }

    public void update(float delta) {

    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public OrthographicCamera getMenuCamera() {
        return menuCamera;
    }

    public Viewport getMenuViewport() {
        return menuViewport;
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public int getSelectedFloor() {
        return selectedFloor;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        if(selectedFloor != -1){
            Vector2 worldTouch = menuViewport.unproject(new Vector2(x, y));

            if(worldTouch.y < 300f && floors.get(selectedFloor).controlTab(worldTouch)) {
                return false;
            }
            floors.get(selectedFloor).isSelected = false;

        }
        selectedFloor = -1;
        Vector2 worldTouch = viewport.unproject(new Vector2(x, y));
        for(int i = 0; i < floors.size(); i++) {
            if(distance(worldTouch, new Vector2(floors.get(i).xCoor, floors.get(i).yCoor)) < 100f) {
                selectedFloor = i;
                floors.get(i).isSelected = true;
                break;
            }
        }
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        camera.translate(-deltaX, deltaY);
        if(camera.position.x < GameConfig.CAMERA_MIN_X)
            camera.position.x = GameConfig.CAMERA_MIN_X;
        if(camera.position.x > GameConfig.CAMERA_MAX_X)
            camera.position.x = GameConfig.CAMERA_MAX_X;
        if(camera.position.y < GameConfig.CAMERA_MIN_Y)
            camera.position.y = GameConfig.CAMERA_MIN_Y;
        if(camera.position.y > GameConfig.CAMERA_MAX_Y)
            camera.position.y = GameConfig.CAMERA_MAX_Y;
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        if((initialDistance / distance) > 1f) {
            camera.zoom = camera.zoom + ((initialDistance / distance) - 1f) / 50f;
            camera.zoom = Math.min(camera.zoom, 2f);
        } else if((initialDistance / distance) < 0.5f) {
            camera.zoom = camera.zoom - ( 1f - (initialDistance / distance)) / 50f;
            camera.zoom = Math.max(camera.zoom, 1f);
        }

        //camera.zoom = (initialDistance / distance) * camera.zoom;
        camera.update();
        System.out.println((initialDistance / distance) + "-" + camera.zoom);
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }

    private double distance(Vector2 object1, Vector2 object2){
        return Math.sqrt(Math.pow((object2.x - object1.x), 2) + Math.pow((object2.y - object1.y), 2));
    }
}
