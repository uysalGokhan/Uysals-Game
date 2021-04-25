package com.uysals.game.warofages.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.uysals.game.warofages.GameConfig;

public class Floor {
    public float xCoor;
    public float yCoor;
    public int isDisabled;
    public int region;
    public boolean isSelected;
    public int building;

    public Floor(float xCoor, float yCoor, int isDisabled, int region) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.isDisabled = isDisabled;
        this.region = region;
        this.isSelected = false;
    }

    public void draw(SpriteBatch batch) {
        if(building != 0) {
            batch.draw(GameConfig.buildingRegions.get(building - 1), xCoor - 128f, yCoor - 128f);
        } else {
            batch.draw(GameConfig.textureRegions.get(region), xCoor - 128f, yCoor - 128f);
        }

        if(isDisabled == 1) {
            batch.draw(GameConfig.disabledFloor, xCoor - 128f, yCoor - 128f);
        } else if(isDisabled == 2) {
            batch.draw(GameConfig.disabledFloor2, xCoor - 128f, yCoor - 128f);
        }
        if(isSelected && isDisabled != 2){
            batch.draw(GameConfig.selectedFloor, xCoor -128f, yCoor - 128f);
        }
    }

    public void drawMenu(SpriteBatch batch) {
        float needWidth = GameConfig.availableBuilds[region].length * 300f - 44f;
        if(region != 0 && building == 0 && isDisabled != 2) {
            batch.draw(GameConfig.buildingMenu, 10f, 0f, GameConfig.menuViewPortWith - 20f, 300f);

            for(int i = 0; i < GameConfig.availableBuilds[region].length; i++) {
                batch.draw(GameConfig.buildingRegions.get(GameConfig.availableBuilds[region][i]), GameConfig.menuViewPortWith / 2 - (needWidth / 2) + (i * 300f), 22f);
            }
        }
    }

    public boolean controlTab(Vector2 worldTouch) {
        if(region != 0 && building == 0 && isDisabled != 2) {
            float needWidth = GameConfig.availableBuilds[region].length * 300f - 44f;
            for(int i = 0; i < GameConfig.availableBuilds[region].length; i++) {
                if(distance(worldTouch, new Vector2(GameConfig.menuViewPortWith / 2 - (needWidth / 2) + (i * 300f) + 128f, 150f)) < 100f) {
                    building = GameConfig.availableBuilds[region][i] + 1;
                    break;
                }
            }
        } else {
            return false;
        }
        return  true;
    }

    private double distance(Vector2 object1, Vector2 object2){
        return Math.sqrt(Math.pow((object2.x - object1.x), 2) + Math.pow((object2.y - object1.y), 2));
    }
}
