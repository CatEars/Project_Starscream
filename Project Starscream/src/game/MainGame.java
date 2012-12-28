package game;

import input.InputMaster;
import collision.CollisionMaster;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import entities.Player;

public class MainGame {
	GameScreen master;
	CollisionMaster collisionHandler;
	EntityMaster entitiesHandler;
	InputMaster inputHandler;
	
	public MainGame(GameScreen Master) {
		master = Master;
		collisionHandler = new CollisionMaster();
		entitiesHandler = new EntityMaster();
		inputHandler = new InputMaster();
	}

	public void resize(int width, int height) {
		//Set game size to width,height		
	}

	public void act() {
		collisionHandler.check();
		entitiesHandler.act();
		inputHandler.act();
		
	}

	public SpriteBatch getSpritebatch() {
		return master.getSpriteBatch();		
	}

	public Player getPlayer() {
		return entitiesHandler.getPlayer();
	}

}
