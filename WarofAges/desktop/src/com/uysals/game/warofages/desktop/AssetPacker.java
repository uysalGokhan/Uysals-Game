package com.uysals.game.warofages.desktop;

import java.io.File;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class AssetPacker {

    private static final boolean DRAW_DEBUG_OUTLINE = false;

    private static final String RAW_ASSETS_PATH = "assets_raw";
    private static final String ASSETS_PATH = "assets";


    public static void main(String[] args) {

        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.debug = DRAW_DEBUG_OUTLINE;
        settings.maxHeight = 4096;
        settings.maxWidth = 4096;

        new File(ASSETS_PATH + "/gameBasic").mkdirs();

        TexturePacker.process(settings,
                RAW_ASSETS_PATH + "",
                ASSETS_PATH + "/gameBasic",
                "gui");




    }
}