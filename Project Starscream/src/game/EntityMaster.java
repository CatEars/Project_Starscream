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

	public Player getPlayer() {
		return player;
	}

	public void initialize() {
				
	}

}
