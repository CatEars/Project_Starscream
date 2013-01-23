package game;

import java.awt.Dimension;
import java.util.ArrayList;

import ai.CollisionMaster;
import ai.IntervalScheduler;

import com.badlogic.gdx.math.Vector2;

import entities.Enemy;
import entities.Laser;
import entities.Missile;
import entities.Player;

public class EntityMaster {
	private Player player;
	private MainGame master;
	private CollisionMaster cm;
	ArrayList<Laser> laserList;
	ArrayList<Enemy> enemyList;
	ArrayList<Missile> missileList;
	IntervalScheduler enemyIS;
	private Dimension applicationSize;
	
	public EntityMaster(MainGame mg) {
		player = new Player();
		master = mg;
		laserList = new ArrayList<Laser>();
		enemyList = new ArrayList<Enemy>();
		missileList = new ArrayList<Missile>();
		enemyIS = new IntervalScheduler();	
		applicationSize = master.getApplicationSize();
	}

	public void initialize() {
		cm = master.getCollisionMaster();		
	}

	public void testMissile(Enemy e){
		missileList.add(new Missile(e,player));
	}
	
	public void fireLaser() {
		Laser l = new Laser(player.pos.x + player.getWidth()/2 - 3 , player.pos.y + player.getHeight()-1);
		laserList.add(l);
		cm.checkLaserHit(l);
	}

	public void act() {
		player.act();
		enemyIS.act();		
		
		//Enemy spawn
		if (enemyIS.isReady()) {
			enemyList.add(new Enemy(0, applicationSize.height/2 + 100));			
		}
				
		//Enemy act
		for (int i = 0; i < enemyList.size(); i++) {
			Enemy e = enemyList.get(i);
			e.act();
			if(e.isReady()){
				testMissile(e);
			}
		}
		
		//Laser act && remove
		for (int i = 0; i < laserList.size(); i++) {
			Laser l = laserList.get(i);
			l.act();
			if (l.hasExpired()) {
				laserList.remove(i);
				i--;
			}
		}
		
		//Enemy Missile act
		for (int i = 0; i < missileList.size(); i++) {
			Missile m = missileList.get(i);
			m.act();			
		}

	}

	public void movePlayerUp() {
		if (player.pos.y < applicationSize.height / 4) {
			player.pos.y += 3;
		}
	}

	public void movePlayerDown() {
		if (player.pos.y > 5) {
			player.pos.y -= 3;
		}
	}

	public void movePlayerLeft() {
		if (player.pos.x > 5) {
			player.pos.x -= 3;
		}
	}

	public void movePlayerRight() {
		if (player.pos.x < applicationSize.width - player.getWidth() - 5) {
			player.pos.x += 3;
		}
	}

	public Player getPlayer() {
		return player;
	}

	public ArrayList<Laser> getLasers() {
		return laserList;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemyList;
	}

	public ArrayList<Missile> getMissiles() {
		return missileList;		
	}
	
	public void removePlayerHP(int h){
		player.removeHP(h);
	}

	public int getPlayerHP() {		
		return player.getHP();
	}

}
