package entities;

import util.IntervalScheduler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class HeatSeeker {
	public Vector2 position;
	public Vector2 speed;
	private Sprite sprite;
	private IntervalScheduler is;
	private Enemy target;
	private boolean engaged = false;
	private boolean hasExpired = false;
	private Rectangle rect;
	private Vector2 startingSpeed;
	private float initialSpeed = 1;

	public HeatSeeker(Player creator, Enemy targ) {
		target = targ;
		position = new Vector2(creator.getPosition());
		position.x += creator.getSprite().getWidth() / 2;
		position.y += creator.getSprite().getHeight() / 2;
		rect = new Rectangle(position.x - 4, position.y - 4, 8, 8);
		speed = new Vector2();
		is = new IntervalScheduler(100);
		startingSpeed = new Vector2(initialSpeed, initialSpeed);
		startingSpeed.rotate((float) (Math.random() * 360));
		if(Math.random() < 0.8){
		sprite = new Sprite(new Texture(Gdx.files.internal("Missile 1.png")));
		} else {
			sprite = new Sprite(new Texture(Gdx.files.internal("Missile 3.png")));
		}
		sprite.setSize(16, 16);
	}

	public Sprite getSprite(){
		sprite.setX(position.x - sprite.getWidth()/2);
		sprite.setY(position.y - sprite.getHeight()/2);
		sprite.setRotation(sprite.getRotation() + 5f);
		return sprite;		
	}
	
	public Rectangle getRect() {
		rect.x = position.x - 4;
		rect.y = position.y - 4;
		return rect;
	}

	public void act() {
		if (!target.hasExpired()) {
			float dx = target.getPosition().x - position.x;
			float dy = target.getPosition().y - position.y;
			double length = Math.sqrt(dx * dx + dy * dy);
			speed.x = (float) (speed.x * 0.91 + (dx / (length)) * 0.5);
			speed.y = (float) (speed.y * 0.91 + (dy / (length)) * 0.5);
		} else {
			speed.x *= 1.01;
			speed.y *= 1.01;
		}

		if (is.getTicker() < 40 && !engaged) {
			position.add(startingSpeed);
		} else {
			engaged = true;
			position.add(speed);
		}
		is.act();
	}

	public boolean hasTarget() {
		return !target.hasExpired();
	}

	public void setTarget(Enemy e) {
		target = e;
	}

	public void destroy() {
		hasExpired = true;
	}

	public boolean hasExpired() {
		return hasExpired;
	}

}
