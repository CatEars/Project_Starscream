package launchers;

import game.GameScreen;

import com.badlogic.gdx.Game;

public class GameStarter extends Game{	
	
	public GameStarter(){
		super();
	}
	
	public void create() {
		setScreen(new GameScreen());		
	}

}
