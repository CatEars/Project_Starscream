package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {	
	public Vector2 pos = new Vector2(20,20);
	public Rectangle rectangle = new Rectangle();
	public Sprite sprite;
	
	public Player(){		
		sprite = new Sprite(new Texture("Spacestuff!.png"));
		rectangle.width = sprite.getWidth();
		rectangle.height = sprite.getHeight();
	}
	
	public Sprite getSprite(){
		sprite.setPosition(pos.x, pos.y);
		return sprite;
	}
	
	public void act(){		
		
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
	
}
