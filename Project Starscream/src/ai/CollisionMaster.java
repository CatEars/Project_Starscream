package ai;

import entities.Enemy;
import entities.Laser;
import entities.Missile;
import entities.Player;
import game.EntityMaster;
import game.MainGame;

import java.awt.Dimension;
import java.util.ArrayList;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class CollisionMaster {
	private MainGame master;
	private EntityMaster em;
	
	Player player;
	ArrayList<Laser> laserList;
	ArrayList<Enemy> enemyList;
	ArrayList<Missile> missileList;
	
	private Dimension applicationSize;
	
	public CollisionMaster(MainGame mg){
		master = mg;
	}
	
	public void check() {
		//Enemies out of bounds		
		for (int i = 0; i < enemyList.size(); i++) {
			Enemy e = enemyList.get(i);
			Vector2 v = e.getPosition();
			if(isOutOfBounds(v.x, v.y)){
				enemyList.remove(i);
				i--;
			}
		}
		//Missiles
		for (int i = 0; i < missileList.size(); i++) {
			Missile m = missileList.get(i);
			Vector2 v = m.getPosition();
			//out of bounds
			if(isOutOfBounds(v.x, v.y)){
				missileList.remove(i);
				i--;
				continue;
			}
			//Missiles hit player
			Rectangle pr = player.getRectangle();
			Rectangle mr = m.getRectangle();
			if(Intersector.overlapRectangles(pr, mr)){
				//Remove hitpoints							
				missileList.remove(i);
				i--;
				continue;
			}
		}
		
		
		
	}
	
	public void checkLaserHit(Laser l){
		for (int i = 0; i < enemyList.size(); i++) {
			if(Intersector.overlapRectangles(l.getRectangle(), enemyList.get(i).getRectangle())){
				System.out.println("You hit " + enemyList.get(i).getName() + "!");
				enemyList.remove(i);
				i--;
			}
		}				
	}

	public void initialize() {
		em = master.getEntityMaster();
		player = em.getPlayer();
		laserList = em.getLasers();
		enemyList = em.getEnemies();
		missileList = em.getMissiles();
		applicationSize = master.getApplicationSize();
	}

	private boolean isOutOfBounds(float x, float y){
		if(x < -20 || y < -20){
			return true;
		}
		if(x > applicationSize.getWidth() + 20 || y > applicationSize.getHeight() + 20){
			return true;
		}
		return false;
		
	}
	
}
