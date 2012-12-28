package input;

import game.EntityMaster;
import game.MainGame;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class InputMaster implements InputProcessor{		
	MainGame master;
	EntityMaster em;
	
	public InputMaster(MainGame mg){
		master = mg;		
	}
	
	public void initialize(){
		em = master.getEntityMaster();
	}
	
	public void act(){
		
	}
	
	@Override
	public boolean keyDown(int ke) {
		if(ke == Keys.W)System.out.println("W");		
		if(ke == Keys.A)System.out.println("A");
		if(ke == Keys.S)System.out.println("S");		
		if(ke == Keys.D)System.out.println("D");
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {

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
