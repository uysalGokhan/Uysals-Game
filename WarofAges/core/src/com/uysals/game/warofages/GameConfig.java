package com.uysals.game.warofages;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class GameConfig {
    public static final float WIDTH = 1920f; // pixels
    public static final float HEIGHT = 1080f; // pixels

    public static final float WORLD_CENTER_X = WIDTH / 2f; // world units
    public static final float WORLD_CENTER_Y = HEIGHT / 2f; // world units

    public static TextureRegion disabledFloor = null;
    public static TextureRegion disabledFloor2 = null;

    public static ArrayList<TextureRegion> textureRegions;
}
