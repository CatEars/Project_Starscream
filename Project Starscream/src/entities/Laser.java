package entities;

import com.badlogic.gdx.math.Rectangle;

public class Laser {
	public float x;
	public float y;
	public static float SIZE = 4;		
	public int ticker = 0;
	public Rectangle rectangle;
	
	public Laser(float X, float Y){
		x = X;
		y = Y;
		rectangle = new Rectangle(x,y,5,600);
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
