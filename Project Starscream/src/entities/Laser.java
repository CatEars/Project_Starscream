package entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Laser {	
	private Vector2 pos;
	public static float SIZE = 4;		
	private int ticker = 0;
	private int fadeAwayTime = 15;
	private Rectangle rectangle;
	
	public Laser(float X, float Y){
		pos = new Vector2(X,Y);		
		rectangle = new Rectangle(pos.x,pos.y,5,600);
	}

	public Rectangle getRectangle(){
		return rectangle;
	}
	
	public Vector2 getPosition(){
		return pos;
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
