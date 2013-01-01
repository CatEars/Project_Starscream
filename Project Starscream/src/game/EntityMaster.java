package game;

import java.util.ArrayList;

import ai.CollisionMaster;
import ai.IntervalScheduler;
import entities.Enemy;
import entities.Laser;
import entities.Player;

public class EntityMaster {
	Player player;
	MainGame master;
	CollisionMaster cm;
	ArrayList<Laser> laserList;
	ArrayList<Enemy> enemyList;
	IntervalScheduler IS;
	
	public EntityMaster(MainGame mg){
		player = new Player();
		master = mg;
		laserList = new ArrayList<Laser>();
		enemyList = new ArrayList<Enemy>();
		IS = new IntervalScheduler();
	}
	
	public void initialize() {
		cm = master.getCollisionMaster();		
	}
	
	public void fireLaser() {		
		Laser l = new Laser(player.x-2,player.y+5);
		laserList.add(l);
		cm.checkLaserHit(l);		
	}
	
	public void act() {
		player.act();
		IS.act();
		
		if(IS.isReady()){
			enemyList.add(new Enemy(-10,300));
		}
		
		for (int i = 0; i < enemyList.size(); i++) {
			Enemy e = enemyList.get(i);
			e.act();
		}
		
		for (int i = 0; i < laserList.size(); i++) {
			Laser l = laserList.get(i);			
			l.act();			
			if(l.hasExpired()){
				laserList.remove(i);
				i--;
			}
		}
		
		
	}

	public void movePlayerUp(){
		if(player.y < master.getApplicationSize().height/4){
		player.y += 3;
		}
	}
	
	public void movePlayerDown(){
		if(player.y > 10){
		player.y -= 3;
		}
	}
	
	public void movePlayerLeft(){
		if(player.x > 10){
		player.x -= 3;
		}
	}
	
	public void movePlayerRight(){
		if(player.x < master.getApplicationSize().width - 10){
		player.x += 3;
		}
	}
	
	
	public Player getPlayer() {
		return player;
	}

	

	

	public ArrayList<Laser> getLasers() {		
		return laserList;
	}

	public ArrayList<Enemy> getEnemies(){
		return enemyList;
	}
	
}
