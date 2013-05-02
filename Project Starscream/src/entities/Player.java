package entities;

import util.IntervalScheduler;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player implements Entity{	
	public Vector2 pos = new Vector2(20,20);
	private Rectangle rectangle = new Rectangle();
	private Sprite sprite;
	private int HP = 25;
	private float energy = 100;
	private boolean hasExpired = false;
	private float missiles = 20;
	private IntervalScheduler missileIS;
	
	public Player(){		
		sprite = new Sprite(new Texture("Spacestuff!.png"));
		rectangle.width = sprite.getWidth();
		rectangle.height = sprite.getHeight();
		missileIS = new IntervalScheduler(100);
		missileIS.disableRandom();
		missileIS.disableSelfReset();
	}
	
	public void removeHP(int h){
		HP -= h;
	}
	
	public int getHP(){
		return HP;
	}
	
	public Sprite getSprite(){
		sprite.setPosition(pos.x, pos.y);
		return sprite;
	}
	
	public void act(){		
		if(energy < 100){
			energy += 0.5;
		}
		if(missileIS.isReady() && missiles < 20){
			missiles += 1;
			missileIS.reset();
		}
		if(missileIS.getTicker() < 100){
			missileIS.act();
		}
	}
		
	public float getEnergy(){
		return energy;
	}
	
	public Vector2 getPosition(){
		return pos;
	}

	public Rectangle getRectangle() {
		rectangle.x = pos.x;
		rectangle.y = pos.y;
		return rectangle;
	}

	public float getHeight(){
		return Math.nextUp(rectangle.height);
	}
	
	public float getWidth() {
		return Math.nextUp(rectangle.width);
	}

	public void fireLaser() {
		if(energy > 0){
			energy -= 15;	
		} 
		if(energy < 0){
			energy = 0;
		}
	}
	
	public float getMissiles(){
		return missiles;
	}

	public void kill(){
		hasExpired = true;
	}
	
	/**
	 * returns a number between 0-1, at 1 the missileReadiness is 100%
	 * @return
	 */
	public float getMissileReadiness(){
		return missileIS.getTicker()/100;
	}
	
	@Override
	public boolean hasExpired() {
		return hasExpired;
	}

	public void fireMissile() {
		missiles--;
	}
	
}
