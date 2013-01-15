package entities;

import ai.IntervalScheduler;
import ai.Pattern;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
	public Vector2 position;
	public Rectangle rectangle;
	public String name = "";		
	public IntervalScheduler missileScheduler;	
	
	public Enemy(float X, float Y){
		position = new Vector2(X,Y);
		rectangle = new Rectangle(X,Y,10,10);
		missileScheduler = new IntervalScheduler(75);
	}
		
	public void act(){		
		position = Pattern.doPattern2(position);	
		missileScheduler.act();
	}
	
	public Rectangle getRectangle(){
		rectangle.x = position.x;
		rectangle.y = position.y;				
		return rectangle;
	}	
	
	public void setName(String s){
		name = s;
	}
	
	public String getName(){
		return name;
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public boolean isReady(){
		return missileScheduler.isReady();
	}
}

