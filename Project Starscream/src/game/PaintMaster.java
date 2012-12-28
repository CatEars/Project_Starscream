package game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import entities.Player;

public class PaintMaster {
	MainGame master;
	SpriteBatch batch;
	Player player;
	ShapeRenderer sr;
	OrthographicCamera camera;
	/**
	 * PaintMaster checks all painting. During painting, it reloads everything supposed to be drawn 
	 * from the game and draws it to the games spritebatch
	 * @param Master
	 */
	public PaintMaster(MainGame Master){
		master = Master;	
		camera = new OrthographicCamera(360,360);
		camera.position.set(180, 180, 0);
	}
	
	public void initialize(){
		batch = master.getSpritebatch();
		sr = master.getShapeRenderer();
	}
	
	/**
	 * loads all components that are supposed to be painted and paints them
	 */
	public void paintAll(){
		//load components
		player = master.getPlayer();		
		//Paint components
		sr.begin(ShapeType.FilledRectangle);
		sr.filledRect(player.x-5, player.y-5, 10, 10);
		sr.end();
		//batch.draw();
	}
	
}
