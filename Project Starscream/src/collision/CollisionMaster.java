package collision;

import entities.Enemy;
import entities.Laser;
import entities.Player;
import game.EntityMaster;
import game.MainGame;

import java.util.ArrayList;

import com.badlogic.gdx.math.Intersector;

public class CollisionMaster {
	MainGame master;
	EntityMaster em;
	
	Player player;
	ArrayList<Laser> laserList;
	ArrayList<Enemy> enemyList;
	
	public CollisionMaster(MainGame mg){
		master = mg;
	}
	
	public void check() {
		
	}
	
	public void checkLaserHit(Laser l){
		for (int i = 0; i < enemyList.size(); i++) {
			if(Intersector.overlapRectangles(l.getRectangle(), enemyList.get(i).getRectangle())){
				System.out.println("You hit a target!");
			}
		}
	}

	public void initialize() {
		em = master.getEntityMaster();
		player = em.getPlayer();
		laserList = em.getLasers();
		enemyList = em.getEnemies();
	}

}
