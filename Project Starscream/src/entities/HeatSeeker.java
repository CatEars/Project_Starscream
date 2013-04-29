package entities;

import util.IntervalScheduler;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class HeatSeeker {
	public Vector2 position;
	public Vector2 speed;
	public IntervalScheduler is;
	private Enemy target;
	private boolean engaged = false;
	private boolean hasExpired = false;
	private Rectangle rect;
	
	public HeatSeeker(Vector2 pos, Enemy targ) {
		target = targ;
		position = new Vector2(pos);
		rect = new Rectangle(position.x-4,position.y-4,8,8);
		speed = new Vector2();
		is = new IntervalScheduler(100);
	}

	public Rectangle getRect(){
		rect.x = position.x-4;
		rect.y = position.y-4;
		return rect;
	}
	
	public void act() {
		if (!target.isDead()) {
			float dx = target.getPosition().x - position.x;
			float dy = target.getPosition().y - position.y;			
			double length = Math.sqrt(dx*dx+dy*dy);
			speed.x = (float) (dx/length) * 3;
			speed.y = (float) (dy/length) * 3;
		} else {				
			speed.x *=1.01;
			speed.y *=1.01;
		}
		if (is.getTicker() < 40 && !engaged) {
			position.x += 1;
			position.y += 0.5;
		} else {
			engaged = true;
			position.add(speed);
		}
		is.act();
	}

	public void destroy(){
		hasExpired = true;
	}
	
	public boolean hasExpired() {
		return hasExpired;
	}

}
