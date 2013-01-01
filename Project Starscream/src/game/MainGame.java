package game;

import input.InputMaster;

import java.awt.Dimension;

import ai.CollisionMaster;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import entities.Player;

public class MainGame {
	GameScreen master;
	CollisionMaster collisionHandler;
	EntityMaster entitiesHandler;
	InputMaster inputHandler;
	int width = 600;
	int height = 480;
	public MainGame(GameScreen Master) {
		master = Master;
		collisionHandler = new CollisionMaster(this);
		entitiesHandler = new EntityMaster(this);
		inputHandler = new InputMaster(this);		
	}

		
	public void resize(int Width, int Height) {
		width = Width;
		height = Height;
	}

	public void act() {
		collisionHandler.check();
		entitiesHandler.act();	
		inputHandler.act();
	}

	public void initialize(){
		inputHandler.initialize();
		entitiesHandler.initialize();
		collisionHandler.initialize();		
	}
	
	public SpriteBatch getSpritebatch() {
		return master.getSpriteBatch();		
	}

	public Player getPlayer() {
		return entitiesHandler.getPlayer();
	}

	public InputProcessor getInputMaster() {
		return inputHandler;
	}

	public EntityMaster getEntityMaster() {
		return entitiesHandler;
	}

	public ShapeRenderer getShapeRenderer() {
		
		return master.getShapeRenderer();
	}


	public Dimension getApplicationSize() {				
		return new Dimension(width, height);
	}


	public CollisionMaster getCollisionMaster() {		
		return collisionHandler;
	}

}
