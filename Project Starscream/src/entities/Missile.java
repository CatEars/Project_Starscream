package entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Missile {
	public Vector2 position;	
	public Rectangle rectangle;
	public Vector2 speed;
	public static int maxspeed = 500;
	
	public Missile(Enemy e, Player p){
		position = new Vector2(e.getPosition());		
		rectangle = new Rectangle(position.x,position.y,3,3);
		Vector2 startPosition = new Vector2(position);
		startPosition.x += e.getWidth()/2;
		startPosition.y += e.getHeight()/2;
		Vector2 targetposition = new Vector2(p.getPosition());
		targetposition.x += p.getWidth()/2;
		targetposition.y += p.getHeight()/2;
		float deltaX = (targetposition.x - startPosition.x);
		float deltaY = (targetposition.y - startPosition.y);
		float hypothenuse = (deltaX * deltaX + deltaY * deltaY);		
		speed = new Vector2();
		speed.x = maxspeed * (deltaX / hypothenuse);
		speed.y = maxspeed * (deltaY / hypothenuse);
	}
	
	public void act(){
		position.add(speed);		
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public Rectangle getRectangle(){
		rectangle.x = position.x;
		rectangle.y = position.y;
		return rectangle;		
	}
	
	
	
	
}
