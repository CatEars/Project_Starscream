package game;

import entities.Player;

public class EntityMaster {
	Player player;
	
	public EntityMaster(){
		player = new Player();
	}
	
	public void act() {
		player.act();
		
	}

	public Player getPlayer() {
		return player;
	}

}
