package Rungunguns.desktop;

import org.mini2Dx.desktop.DesktopMini2DxConfig;

import com.badlogic.gdx.backends.lwjgl.DesktopMini2DxGame;

import Rungunguns.Maingame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		DesktopMini2DxConfig config = new DesktopMini2DxConfig(Maingame.GAME_IDENTIFIER);
		config.width = 680;
		config.height = 280;
		config.resizable = false;
		config.vSyncEnabled = true;
		new DesktopMini2DxGame(new Maingame(), config);
	}
}
