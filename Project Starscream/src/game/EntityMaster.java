package game;

import java.awt.Dimension;
import java.util.ArrayList;

import org.lwjgl.util.Point;

import util.IntervalScheduler;
import ai.CollisionMaster;
import ai.Gravity;
import ai.Pattern;

import com.badlogic.gdx.math.Vector2;

import entities.Enemy;
import entities.Explosion;
import entities.HeatSeeker;
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
	ArrayList<Explosion> explosionList;
	ArrayList<HeatSeeker> heatList;
	IntervalScheduler enemyIS;
	private Dimension applicationSize;
	private Gravity gravity;
	
	private int enemyCounter = 0;
	private boolean enemiesAct = true;
	
	public EntityMaster(MainGame mg) {
		player = new Player();
		master = mg;
		laserList = new ArrayList<Laser>();
		enemyList = new ArrayList<Enemy>();
		missileList = new ArrayList<Missile>();
		explosionList = new ArrayList<Explosion>();
		heatList = new ArrayList<HeatSeeker>();
		enemyIS = new IntervalScheduler();
		applicationSize = master.getApplicationSize();
		Point[] grav = {new Point(300,240), new Point(100,240), new Point(300,100), new Point(300,400)};
		Point[] degrav = {};
		gravity = new Gravity(grav,degrav);
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
		if(player.getEnergy() > 0){
		Laser l = new Laser(player.pos.x + player.getWidth() / 2 - 3,
				player.pos.y + player.getHeight() - 1);
			laserList.add(l);
			cm.checkLaserHit(l);
			player.fireLaser();
		}
	}

	public void firePlayerMissile(){
		if(enemyList.size() > 0){
			Enemy e = enemyList.get((int)(Math.random() * enemyList.size()));
			heatList.add(new HeatSeeker(player.pos,e));
		}
	}
	
	public int getEnemiesOnScreen(){
		return enemyList.size();
	}
	
	private void enemiesAct(boolean enemySpawn) {
		// Enemy spawn
		if (enemyIS.isReady() && enemySpawn) {
			Point p = spawnEnemyPosition();
			enemyList.add(new Enemy(p.getX(),p.getY()));
			enemyCounter++;
		}

		// Enemy act
		for (int i = 0; i < enemyList.size(); i++) {
			Enemy e = enemyList.get(i);
			e.act();
			if (e.isReady() && enemySpawn) {
				testMissile(e);
			}
			gravity.moveEnemy(e);
			if(e.isDead()){
				float x = e.getPosition().x + e.getSprite().getWidth()/2;
				float y = e.getPosition().y + e.getSprite().getHeight()/2;
				explosionList.add(new Explosion(x,y));
				enemyList.remove(i);
				i--;
			}
		}

		// Enemy Missile act
		for (int i = 0; i < missileList.size(); i++) {
			Missile m = missileList.get(i);
			m.act();
		}
	}

	private Point spawnEnemyPosition() {
		double randOne = Math.random();
		Point p;		
		if(randOne <= 0.3333){		
			randOne = Math.random();
			while(randOne < 0.3){
				randOne = Math.random();
			}
			p = new Point(-10,(int)(applicationSize.height*randOne));
		} else if(randOne <= 0.66666 ){
			p = new Point((int) (applicationSize.width*randOne),(applicationSize.height));
		} else {
			p = new Point(applicationSize.width,(int)(applicationSize.height*randOne));
		}
		return p;
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
		
		//Explosion act && remove
		for (int i = 0; i < explosionList.size(); i++) {
			Explosion ex = explosionList.get(i);
			ex.act();
			if(ex.hasExpired()){
				explosionList.remove(i);
				i--;
			}
		}
		
		//HeatSeeker act && remove
		for(int i = 0; i < heatList.size(); i++){
			HeatSeeker hs = heatList.get(i);
			hs.act();
			if(!hs.hasTarget() && enemyList.size() > 0){
				hs.setTarget(enemyList.get(0));
			}
			if(hs.hasExpired()){
				heatList.remove(i);
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

	public ArrayList<Explosion> getExplosions() {
		return explosionList;
	}

	public ArrayList<HeatSeeker> getHeatSeekers() {
		return heatList;
	}

}
