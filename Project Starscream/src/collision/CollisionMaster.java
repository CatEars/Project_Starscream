package collision;

import entities.Laser;
import entities.Player;
import game.EntityMaster;
import game.MainGame;

import java.util.ArrayList;

public class CollisionMaster {
	MainGame master;
	EntityMaster em;
	
	Player player;
	ArrayList<Laser> laserList;
	
	public CollisionMaster(MainGame mg){
		master = mg;
	}
	
	public void check() {
		
	}

	public void initialize() {
		em = master.getEntityMaster();
		player = em.getPlayer();
		laserList = em.getLasers();
	}

}
