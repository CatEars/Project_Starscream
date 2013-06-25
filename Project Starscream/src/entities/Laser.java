package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Laser {	
	private static int fadeAwayTime = 15;
	private Vector2 pos;	
	private int ticker;	
	private Rectangle rectangle;
	private Sprite sprite;
	
	public Laser(float X, float Y){
		ticker = 0;
		sprite =  = new Sprite(new Texture("Lazor.png"));
		pos = new Vector2(X,Y);		
		rectangle = new Rectangle(pos.x,pos.y,sprite.getWidth(),sprite.getHeight());
	}

	public Sprite getSprite(){
		sprite.setX(pos.x);
		sprite.setY(pos.y);
		return sprite;
	}
	
	public Rectangle getRectangle(){
		return rectangle;
	}
	
	public Vector2 getPosition(){
		return pos;
	}
	
	public float getWidth(){
		return rectangle.width;
	}
	
	public float getHeight(){
		return rectangle.height;
	}
	
	public boolean hasExpired(){
		if(ticker > fadeAwayTime){
			return true;
		} else {
			return false;
		}
	}
	
	public void act() {
		ticker++;
	}
}
