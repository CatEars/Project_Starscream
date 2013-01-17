package entities;

import ai.IntervalScheduler;
import ai.Pattern;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
	public Vector2 position;
	public Rectangle rectangle;
	public String name = "";		
	public IntervalScheduler missileScheduler;	
	public Sprite sprite;
	public double randomNumber;
	
	public Enemy(float X, float Y){
		position = new Vector2(X,Y);
		rectangle = new Rectangle(X,Y,10,10);
		missileScheduler = new IntervalScheduler(75);
		sprite = new Sprite(new Texture("SurprisedStuff.png"));
		randomNumber = Math.random();
		if(randomNumber < 0.50){
			position.x = 600-X;			
		}
		if(randomNumber < 0.10){
			System.out.println("Pattern4");
			}else if(randomNumber < 0.50){
				System.out.println("Pattern5");
			}else if (randomNumber < 0.60){
				System.out.println("Pattern3");
			} else if(randomNumber < 0.80){
				System.out.println("Pattern2");			
			} else {
				System.out.println("Pattern1");
			}
	}
		
	public void act(){		
		if(randomNumber < 0.10){
		position = Pattern.doPattern4(position);
		}else if(randomNumber < 0.50){
			position = Pattern.doPattern5(position);
		}else if (randomNumber < 0.60){
			position = Pattern.doPattern3(position);
		} else if(randomNumber < 0.80){
			position = Pattern.doPattern2(position);			
		} else {
			position = Pattern.doPattern1(position);
		}
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

