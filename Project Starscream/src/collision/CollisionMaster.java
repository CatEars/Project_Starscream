package collision;

import game.EntityMaster;
import game.MainGame;

public class CollisionMaster {
	MainGame master;
	EntityMaster em;
	
	public CollisionMaster(MainGame mg){
		master = mg;
	}
	public void check() {

		
	}

	public void initialize() {
		em = master.getEntityMaster();
	}

}
