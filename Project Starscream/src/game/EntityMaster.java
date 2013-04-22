package game;

import java.awt.Dimension;
import java.util.ArrayList;

import util.IntervalScheduler;
import ai.CollisionMaster;
import ai.Gravity;
import ai.Pattern;

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

	private int enemyCounter = 0;
	private boolean enemiesAct = true;

	public EntityMaster(MainGame mg) {
		player = new Player();
		master = mg;
		laserList = new ArrayList<Laser>();
		enemyList = new ArrayList<Enemy>();
		missileList = new ArrayList<Missile>();
		enemyIS = new IntervalScheduler();
		applicationSize = master.getApplicationSize();
	}

	public int getSpawnedEnemies() {
		return enemyCounter;
	}

	public void initialize() {
		cm = master.getCollisionMaster();
	}

	public void testMissile(Enemy e) {
		missileList.add(new Missile(e, player));
	}

	public void fireLaser() {
		Laser l = new Laser(player.pos.x + player.getWidth() / 2 - 3,
				player.pos.y + player.getHeight() - 1);
		laserList.add(l);
		cm.checkLaserHit(l);
	}

	public int getEnemiesOnScreen(){
		return enemyList.size();
	}
	
	private void enemiesAct(boolean enemySpawn) {
		// Enemy spawn
		if (enemyIS.isReady() && enemySpawn) {
			enemyList.add(new Enemy(0, applicationSize.height / 2 + 100));
			enemyCounter++;
		}

		// Enemy act
		for (int i = 0; i < enemyList.size(); i++) {
			Enemy e = enemyList.get(i);
			e.act();
			if (e.isReady() && enemySpawn) {
				testMissile(e);
			}
			e.position = getNewPosition(e.getID(), e.getPosition());
		}

		// Enemy Missile act
		for (int i = 0; i < missileList.size(); i++) {
			Missile m = missileList.get(i);
			m.act();
		}
	}

	public void act(boolean enemySpawn) {
		player.act();
		enemyIS.act();
		
		if(enemiesAct){
			enemiesAct(enemySpawn);
		}
		
		// Laser act && remove
		for (int i = 0; i < laserList.size(); i++) {
			Laser l = laserList.get(i);
			l.act();
			if (l.hasExpired()) {
				laserList.remove(i);
				i--;
			}
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

	private Vector2 getNewPosition(String id, Vector2 v) {
		switch(id){
			case "1":
				return Pattern.doPattern1(v);
			case "2":
				return Pattern.doPattern2(v);
			case "3":
				return Pattern.doPattern3(v);
			case "4":
				return Pattern.doPattern4(v);
			case "5":
				return Pattern.doPattern5(v);
			case "6":
				//return Gravity.doPattern(v);
				return new Vector2(-500, -500);
			default:
				return new Vector2(-500, -500);
		}
	}

	public void removePlayerHP(int h) {
		player.removeHP(h);
	}

	public int getPlayerHP() {
		return player.getHP();
	}

	/**
	 * enables enemy spawning
	 */
	public void enableEnemies() {
		enemiesAct = true;
	}

	/**
	 * Disables enemy spawning
	 */
	public void disableEnemies() {
		enemiesAct = false;
	}

	public void rotatePlayerLeft() {				
		if(player.sprite.getRotation() != 30){
			player.sprite.setRotation(30);
		}
	}
	
	public void rotatePlayerRight() {
		if(player.sprite.getRotation() != -30){
			player.sprite.setRotation(-30);
		}		
	}
	
	public void resetPlayerRotation(){
		player.sprite.setRotation(0);
	}

}
