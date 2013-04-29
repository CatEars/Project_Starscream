package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player implements Entity{	
	public Vector2 pos = new Vector2(20,20);
	public Rectangle rectangle = new Rectangle();
	public Sprite sprite;
	public int HP = 25;
	private float energy = 100;
	
	public Player(){		
		sprite = new Sprite(new Texture("Spacestuff!.png"));
		rectangle.width = sprite.getWidth();
		rectangle.height = sprite.getHeight();
	}
	
	public void removeHP(int h){
		HP -= h;
	}
	
	public int getHP(){
		return HP;
	}
	
	public Sprite getSprite(){
		sprite.setPosition(pos.x, pos.y);
		return sprite;
	}
	
	public void act(){		
		if(energy < 100){
			energy += 0.5;
		}
	}
		
	public float getEnergy(){
		return energy;
	}
	
	public Vector2 getPosition(){
		return pos;
	}

	public Rectangle getRectangle() {
		rectangle.x = pos.x;
		rectangle.y = pos.y;
		return rectangle;
	}

	public float getHeight(){
		return Math.nextUp(rectangle.height);
	}
	
	public float getWidth() {
		return Math.nextUp(rectangle.width);
	}

	public void fireLaser() {
		if(energy > 0){
			energy -= 15;	
		} 
		if(energy < 0){
			energy = 0;
		}
	}
	
}
