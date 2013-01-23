package game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import entities.Enemy;
import entities.Laser;
import entities.Missile;
import entities.Player;

public class PaintMaster {
	MainGame master;
	SpriteBatch batch;	
	ShapeRenderer sr;
	OrthographicCamera camera;
	EntityMaster em;
	BitmapFont bf;
	
	Player player;
	ArrayList<Laser> laserList;
	ArrayList<Enemy> enemyList;
	ArrayList<Missile> missileList;
	/**
	 * PaintMaster checks all painting. During painting, it reloads everything supposed to be drawn 
	 * from the game and draws it to the games spritebatch
	 * @param Master
	 */
	
	public PaintMaster(MainGame Master){
		master = Master;	
		camera = new OrthographicCamera(360,360);
		camera.position.set(180, 180, 0);
		bf = new BitmapFont();
	}
	
	public void initialize(){
		batch = master.getSpritebatch();
		sr = master.getShapeRenderer();
		em = master.getEntityMaster();
		player = master.getPlayer();
		laserList = em.getLasers();
		enemyList = em.getEnemies();
		missileList = em.getMissiles();
	}
	
	public void paintAll(){					
		sr.begin(ShapeType.FilledRectangle);

//		sr.setColor(Color.WHITE);
//		Rectangle pr = player.getRectangle();
//		sr.filledRect(player.pos.x, player.pos.y, 10, 10);
		//lasers
//		sr.setColor(Color.RED);
//		for (int i = 0; i < laserList.size(); i++) {
//			Laser l = laserList.get(i);
//			Rectangle r = l.getRectangle();			
//			sr.filledRect(r.x,r.y,r.width,r.height);
//		}			
		//enemies
//		sr.setColor(Color.PINK);
//		for (int i = 0; i < enemyList.size(); i++) {
//			Enemy e = enemyList.get(i);
//			Rectangle r = e.getRectangle();
//			sr.filledRect(r.x, r.y, r.width, r.height);
//		}
		//Missiles
		sr.setColor(Color.CYAN);
		for (int i = 0; i < missileList.size(); i++) {
			Missile m = missileList.get(i);
			Rectangle r = m.getRectangle();
			sr.filledRect(r.x, r.y, r.width, r.height);
		}
		sr.end();
		
		//Player
		batch.begin();
		Sprite playerSprite = player.getSprite();		
		playerSprite.draw(batch);
		bf.draw(batch, "Player HP: " + player.getHP(), 5, 20);
		
		//Enemies
		for (int i = 0; i < enemyList.size(); i++) {
			Enemy e = enemyList.get(i);
			Sprite s = e.getSprite();
			s.draw(batch);
		}
		
		//Lasers
		for (int i = 0; i < laserList.size(); i++) {
			Laser l = laserList.get(i);
			Sprite s = l.getSprite();
			s.draw(batch);
		}
		batch.end();				
		
	}
	
}
