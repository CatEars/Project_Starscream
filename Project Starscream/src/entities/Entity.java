package entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public interface Entity {	
	
	public Sprite getSprite();
	public Rectangle getRectangle();
	public void act();
}
