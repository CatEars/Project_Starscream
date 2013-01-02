package entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Missile {
	public Vector2 position;	
	public Rectangle rectangle;
	public Vector2 speed;
	public static int maxspeed = 500;
	
	public Missile(Vector2 startposition, Player p){
		position = startposition;		
		rectangle = new Rectangle(position.x,position.y,3,3);
		Vector2 targetposition = p.getPosition();  
		float deltaX = (targetposition.x - startposition.x);
		float deltaY = (targetposition.y - startposition.y);
		float hypothenuse = (deltaX * deltaX + deltaY * deltaY);		
		speed = new Vector2();
		speed.x = maxspeed * (deltaX / hypothenuse);
		speed.y = maxspeed * (deltaY / hypothenuse);
	}
	
	public void act(){
		position.add(speed);
	}
	
	public Rectangle getRectangle(){
		rectangle.x = position.x;
		rectangle.y = position.y;
		return rectangle;		
	}
	
	
	
	
}
