package com.uysals.game.warofages.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.uysals.game.warofages.GameConfig;

public class Floor {
    public float xCoor;
    public float yCoor;
    public int isDisabled;
    public int region;
    public boolean isSelected;

    public Floor(float xCoor, float yCoor, int isDisabled, int region) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.isDisabled = isDisabled;
        this.region = region;
        this.isSelected = false;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(GameConfig.textureRegions.get(region), xCoor - 128f, yCoor - 128f);
        if(isDisabled == 1) {
            batch.draw(GameConfig.disabledFloor, xCoor - 128f, yCoor - 128f);
        } else if(isDisabled == 2) {
            batch.draw(GameConfig.disabledFloor2, xCoor - 128f, yCoor - 128f);
        }
        if(isSelected){
            batch.draw(GameConfig.selectedFloor, xCoor -128f, yCoor - 128f);
        }
    }
}
