package game;

import input.InputMaster;

import java.awt.Dimension;

import util.IntervalScheduler;

import ai.CollisionMaster;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import element.Conversation;
import entities.Player;

public class MainGame {
	private GameScreen master;
	CollisionMaster collisionHandler;
	EntityMaster entitiesHandler;
	InputMaster inputHandler;

	int width = 600;	
	int height = 480;
	private boolean interlude = false;
	private int level = 1;
	private long lastTick;
	
	public Conversation conv = new Conversation();
	
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
	
	/**
	 * Advances the level 1 step, if Interlude is true then there will be a short pause between
	 * the level shift. If it's false it will switch directly
	 * @param Interlude
	 */
	private void advanceLevel(boolean Interlude){		
		level++;
		System.out.println("Advancing level to " + level + "!!!");
		interlude = Interlude;
	}

	/**
	 * Runs the first level until the win condition for level 1 is true: 5 enemies spawned
	 */
	private void actLevelOne(){
		lastTick = System.currentTimeMillis();
		collisionHandler.check();
		entitiesHandler.act(true);	
		inputHandler.act();
		if(entitiesHandler.getSpawnedEnemies() > 5){			
			advanceLevel(true);
		}		
	}
	
	/**
	 * Lets all the monster exit the screen and makes them stop shot at the player. 
	 * The shots already fired at the player will still travel towards him. 
	 */
	private void actInterlude(){
		if(conv.hasEnded()){ //if(Conversation.hasEnded())
			System.out.println("lawl");
			interlude = false;			
		}
		collisionHandler.check();
		entitiesHandler.act(false);
		inputHandler.act();
		master.paintmaster.setDrawnString(conv.getCurrentConPiece());
	}
	
	/**
	 * SecondLevel: 50 enemies
	 */
	private void actLevelTwo(){		
		collisionHandler.check();
		entitiesHandler.act(true);	
		inputHandler.act();
		if(entitiesHandler.getSpawnedEnemies() > 50){
			advanceLevel(false);
		}
	}
	
	/**
	 * Third level: Boss level
	 */
	private void actLevelThree(){
		entitiesHandler.disableEnemies(); //TODO just needs to be called once but to lazy to fix now
		collisionHandler.check();
		entitiesHandler.act(true);	
		inputHandler.act();
	}
	
	
	/**
	 * acts the right level for the game
	 */
	public void act() {
		if(!interlude){
		if(level == 1) actLevelOne();
		if(level == 2) actLevelTwo();
		if(level == 3) actLevelThree();
		} else {
			actInterlude();
		}
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


	public boolean isLost() {
		if(entitiesHandler.getPlayerHP() <= 0){
			return true;
		} else {
			return false;
		}
	}

}
