package entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public interface Entity {		
	public boolean hasExpired = false;
	public Sprite getSprite();
	public Rectangle getRectangle();
	public void act();
	
	/**
	 * Tells wheter or not the entity should be shown on screen. 
	 * If it has collided or should be removed or not. 
	 * @return
	 */
	public boolean hasExpired();
	
}
