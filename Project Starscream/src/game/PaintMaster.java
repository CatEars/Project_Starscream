package game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

import entities.Laser;
import entities.Player;

public class PaintMaster {
	MainGame master;
	SpriteBatch batch;	
	ShapeRenderer sr;
	OrthographicCamera camera;
	EntityMaster em;
	
	Player player;
	ArrayList<Laser> laserList;
	/**
	 * PaintMaster checks all painting. During painting, it reloads everything supposed to be drawn 
	 * from the game and draws it to the games spritebatch
	 * @param Master
	 */
	public PaintMaster(MainGame Master){
		master = Master;	
		camera = new OrthographicCamera(360,360);
		camera.position.set(180, 180, 0);
		laserList = new ArrayList();		
	}
	
	public void initialize(){
		batch = master.getSpritebatch();
		sr = master.getShapeRenderer();
		em = master.getEntityMaster();
		player = master.getPlayer();
		laserList = em.getLasers();
	}
	
	public void paintAll(){		
		//Paint components
		sr.begin(ShapeType.FilledRectangle);
		sr.setColor(Color.WHITE);
		sr.filledRect(player.x-5, player.y-5, 10, 10);
		sr.setColor(Color.RED);
		for (int i = 0; i < laserList.size(); i++) {
			Laser l = laserList.get(i);
			Rectangle r = l.getRectangle();
			sr.filledRect(r.x,r.y,r.width,r.height);
		}
		sr.end();
	}
	
}
