package game;

import entities.Player;

public class EntityMaster {
	Player player;
	MainGame master;
	
	public EntityMaster(MainGame mg){
		player = new Player();
		master = mg;
	}
	
	public void act() {
		player.act();		
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

	public void initialize() {
				
	}

	public void fireLaser() {
		System.out.println("Laser fired");
	}

}
