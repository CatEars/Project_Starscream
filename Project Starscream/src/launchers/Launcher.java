package launchers;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new LwjglApplication(new GameStarter(),"Project Starscream", 600,480, true);
		StartingMenu s = new StartingMenu();
		s.setBounds(500, 500, 600, 480);
		s.setVisible(true);
		
	}

}
