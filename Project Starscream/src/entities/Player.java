package entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {	
	public Vector2 pos = new Vector2(20,20);
	public Rectangle rectangle = new Rectangle();
	
	public Player(){
		rectangle.width = 10;
		rectangle.height = 10;
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
	
}
