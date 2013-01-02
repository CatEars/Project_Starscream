package ai;

import entities.Enemy;
import entities.Laser;
import entities.Missile;
import entities.Player;
import game.EntityMaster;
import game.MainGame;

import java.util.ArrayList;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class CollisionMaster {
	MainGame master;
	EntityMaster em;
	
	Player player;
	ArrayList<Laser> laserList;
	ArrayList<Enemy> enemyList;
	ArrayList<Missile> missileList;
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
		//Missiles out of bounds
		for (int i = 0; i < missileList.size(); i++) {
			Missile m = missileList.get(i);
			Vector2 v = m.getPosition();
			if(isOutOfBounds(v.x, v.y)){
				missileList.remove(i);
				i--;
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
	}

	private boolean isOutOfBounds(float x, float y){
		if(x < -20 || y < -20){
			return true;
		}
		if(x > 600 || y > 600){
			return true;
		}
		return false;
		
	}
	
}
