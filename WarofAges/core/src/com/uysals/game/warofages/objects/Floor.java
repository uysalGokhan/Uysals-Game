package com.uysals.game.warofages.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.uysals.game.warofages.GameConfig;

public class Floor {
    public float xCoor;
    public float yCoor;
    public boolean isDisabled;
    public int region;

    public Floor(float xCoor, float yCoor, boolean isDisabled, int region) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.isDisabled = isDisabled;
        this.region = region;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(GameConfig.textureRegions.get(region), xCoor - 128f, yCoor - 128f);
        if(isDisabled) {
            batch.draw(GameConfig.disabledFloor, xCoor - 128f, yCoor - 128f);
        }
    }
}
