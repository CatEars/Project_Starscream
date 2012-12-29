package input;

import entities.Player;
import game.EntityMaster;
import game.MainGame;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class InputMaster implements InputProcessor{		
	MainGame master;
	EntityMaster em;
	Player player;
	boolean[] KEYS = new boolean[512];
	
	public InputMaster(MainGame mg){
		master = mg;		
	}
	
	public void initialize(){
		em = master.getEntityMaster();
		player = em.getPlayer();
	}
	
	public void act(){				
		if(KEYS[Keys.W] || KEYS[Keys.UP]){
			player.y += 3;
		}
		if(KEYS[Keys.A] || KEYS[Keys.LEFT]){
			player.x -= 3;
		}
		if(KEYS[Keys.S] || KEYS[Keys.DOWN]){
			player.y -= 3;
		}
		if(KEYS[Keys.D] || KEYS[Keys.RIGHT]){
			player.x += 3;
		}

	}
	
	@Override
	public boolean keyDown(int ke) {		
		KEYS[ke]= true;						
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		
		return false;
	}

	@Override
	public boolean keyUp(int ke) {
		KEYS[ke] = false;
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {

		return false;
	}

	@Override
	public boolean scrolled(int arg0) {

		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {

		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {

		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {

		return false;
	}

}
