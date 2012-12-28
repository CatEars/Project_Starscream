package game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import entities.Player;

public class PaintMaster {
	MainGame master;
	SpriteBatch batch;
	Player player;
	/**
	 * PaintMaster checks all painting. During painting, it reloads everything supposed to be drawn 
	 * from the game and draws it to the games spritebatch
	 * @param Master
	 */
	public PaintMaster(MainGame Master){
		master = Master;
		batch = master.getSpritebatch();		
	}
	
	
	/**
	 * loads all components that are supposed to be painted and paints them
	 */
	public void paintAll(){
		//load components
		player = master.getPlayer();
		
		//Paint components
		
		//batch.draw();
	}
	
}
