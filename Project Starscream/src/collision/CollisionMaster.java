package collision;

import entities.Player;
import game.EntityMaster;
import game.MainGame;

public class CollisionMaster {
	MainGame master;
	EntityMaster em;
	Player player;
	
	public CollisionMaster(MainGame mg){
		master = mg;
	}
	
	public void check() {
		
	}

	public void initialize() {
		em = master.getEntityMaster();
		player = em.getPlayer();
	}

}
