package entities;

import util.IntervalScheduler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Explosion implements Entity{
	private Rectangle rect;
	private Sprite sprite;
	private IntervalScheduler explosionIS;		
	private boolean hasExpired = false;
	private int explosionTime = 20;
		
	public Explosion(float x, float y){		
		sprite = new Sprite(new Texture(Gdx.files.internal("Explosion.png")));
		rect = new Rectangle(x,y,20,20);
		explosionIS = new IntervalScheduler(explosionTime);
		explosionIS.disableRandom();
	}

	@Override
	public Sprite getSprite() {
		float f = explosionIS.getTicker();
		if(f <= explosionTime/2){			
			rect.height *= 1.09f;
			rect.width *= 1.09f;
			sprite.setBounds(rect.x-rect.width/2, rect.y-rect.height/2, rect.width, rect.height);			
		} else {
			rect.height *= 0.91f;
			rect.width *= 0.91f;
			sprite.setBounds(rect.x-rect.width/2, rect.y-rect.height/2, rect.width, rect.height);
		}		
		return sprite;
	}

	@Override
	public Rectangle getRectangle() {
		return rect;
	}

	public boolean hasExpired(){
		return hasExpired;
	}
	
	@Override
	public void act() {
		explosionIS.act();
		if(explosionIS.isReady()){
			hasExpired = true;
		}
	}	
	
}
