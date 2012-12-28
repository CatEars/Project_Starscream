package launchers;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LwjglApplication(new GameStarter(),"Project Starscream", 600,480, true);
	}

}
