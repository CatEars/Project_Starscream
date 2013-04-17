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
		//Continous actions
		if(KEYS[Keys.W] || KEYS[Keys.UP]){
			em.movePlayerUp();
		}
		if(KEYS[Keys.A] || KEYS[Keys.LEFT]){
			em.movePlayerLeft();
		}
		if(KEYS[Keys.S] || KEYS[Keys.DOWN]){
			em.movePlayerDown();
		}
		if(KEYS[Keys.D] || KEYS[Keys.RIGHT]){
			em.movePlayerRight();
		}
//		if( KEYS[Keys.SPACE]){
//			em.fireLaser();
//		}
	}
	
	@Override
	public boolean keyDown(int ke) {		
		KEYS[ke]= true;		
		//Single actions
		if(ke == Keys.SPACE){
			em.fireLaser();
		}
		if(ke == Keys.ENTER){
			master.conv.advanceText();
		}
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
