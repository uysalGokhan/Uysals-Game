package com.uysals.game.warofages.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.uysals.game.warofages.GameConfig;
import com.uysals.game.warofages.WarofAges;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = (int) (GameConfig.HEIGHT / 2);
		config.width = (int) (GameConfig.WIDTH / 2);
		new LwjglApplication(new WarofAges(), config);
	}
}
