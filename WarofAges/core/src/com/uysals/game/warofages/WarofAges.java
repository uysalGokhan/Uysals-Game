package com.uysals.game.warofages;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.uysals.game.warofages.screens.loading.LoadingScreen;

public class WarofAges extends Game {

	private AssetManager assetManager;
	private SpriteBatch batch;
	private Preferences prefs;
	private int changeMenuCount;

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		changeMenuCount = 0;
		assetManager = new AssetManager();
		assetManager.getLogger().setLevel(Logger.DEBUG);
		prefs = Gdx.app.getPreferences("WarofAgesData");

		batch = new SpriteBatch();

		newScreen(new LoadingScreen(this));
	}

	public void newScreen(Screen screen) {
		changeMenuCount++;
		setScreen(screen);
	}

	@Override
	public void dispose() {
		assetManager.dispose();
		batch.dispose();
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public Preferences getPreferences() {
		return prefs;
	}
}
