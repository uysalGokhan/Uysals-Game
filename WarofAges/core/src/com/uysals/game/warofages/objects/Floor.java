package com.uysals.game.warofages.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Floor {
    public float xCoor;
    public float yCoor;
    public TextureRegion region;

    public Floor(float xCoor, float yCoor, TextureRegion region) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.region = region;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(region, xCoor - 128f, yCoor - 128f);
    }
}
