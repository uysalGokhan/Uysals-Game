package com.uysals.game.warofages.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetDescriptors {

    public static final AssetDescriptor<TextureAtlas> FLOORS =
            new AssetDescriptor<TextureAtlas>(AssetPaths.FLOORS, TextureAtlas.class);

    public static final AssetDescriptor<TextureAtlas> GUI =
            new AssetDescriptor<TextureAtlas>(AssetPaths.GUI, TextureAtlas.class);


    public static final AssetDescriptor<BitmapFont> FONT24 =
            new AssetDescriptor<BitmapFont>(AssetPaths.UI_FONT24, BitmapFont.class);

    public static final AssetDescriptor<BitmapFont> FONT32 =
            new AssetDescriptor<BitmapFont>(AssetPaths.UI_FONT32, BitmapFont.class);

    public static final AssetDescriptor<BitmapFont> FONT40 =
            new AssetDescriptor<BitmapFont>(AssetPaths.UI_FONT40, BitmapFont.class);

    public static final AssetDescriptor<BitmapFont> FONT48 =
            new AssetDescriptor<BitmapFont>(AssetPaths.UI_FONT48, BitmapFont.class);

    private AssetDescriptors() {
    }
}
