package com.uysals.game.warofages.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetDescriptors {

    public static final AssetDescriptor<TextureAtlas> FLOORS =
            new AssetDescriptor<TextureAtlas>(AssetPaths.FLOORS, TextureAtlas.class);

    private AssetDescriptors() {
    }
}
