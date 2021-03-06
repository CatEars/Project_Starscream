package entities;

import ai.IntervalScheduler;
import ai.Pattern;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
	public Vector2 position;
	private Rectangle rectangle;
	public String name = "";		
	private IntervalScheduler missileScheduler;	
	private Sprite sprite;	
	public String patternID;
	
	public Enemy(float X, float Y){
		position = new Vector2(X,Y);		
		missileScheduler = new IntervalScheduler(75);
		sprite = new Sprite(new Texture("SurprisedStuff.png"));
		rectangle = new Rectangle(X,Y,sprite.getWidth(),sprite.getHeight());
		patternID = "" + ((int)(Math.nextUp((Math.random() * Pattern.numberOfPatterns))) + 1);
		System.out.println("PatternID is: " + patternID);
	}
				
	public void act(){				
		missileScheduler.act();
	}
	
	public Sprite getSprite(){
		sprite.setX(position.x);
		sprite.setY(position.y);
		return sprite;
	}
	
	public Rectangle getRectangle(){
		rectangle.x = position.x;
		rectangle.y = position.y;				
		return rectangle;
	}	
	
	public void setName(String s){
		name = s;
	}
	
	public String getID(){
		return patternID;
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
	
	public void setIntervall(float newIntervall){
		missileScheduler.setIntervall(newIntervall);
	}

	public float getHeight(){
		return rectangle.height;
	}
	
	public float getWidth() {
		return rectangle.width;
	}
}

