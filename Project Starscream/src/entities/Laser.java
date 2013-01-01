package entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Laser {	
	public Vector2 pos;
	public static float SIZE = 4;		
	public int ticker = 0;
	public Rectangle rectangle;
	
	public Laser(float X, float Y){
		pos = new Vector2(X,Y);		
		rectangle = new Rectangle(pos.x,pos.y,5,600);
	}

	public Rectangle getRectangle(){
		return rectangle;
	}
	
	public boolean hasExpired(){
		if(ticker > 20){
			return true;
		} else {
			return false;
		}
	}
	
	public void act() {
		ticker++;
	}
}
