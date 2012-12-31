package entities;

import com.badlogic.gdx.math.Rectangle;

public class Enemy {
	public float x;
	public float y;
	public Rectangle rectangle;
	public String name = "";	
	
	public Enemy(float X, float Y){
		x = X;
		y = Y;
		rectangle = new Rectangle(x,y,10,10);
	}
	
	public Rectangle getRectangle(){
		return rectangle;
	}	
	
	public void setName(String s){
		name = s;
	}
	
	public String getName(){
		return name;
	}
}
