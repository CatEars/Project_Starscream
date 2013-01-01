package ai;

import com.badlogic.gdx.math.Vector2;


public class Pattern {	
	
	public static Vector2 doPattern1(Vector2 v){
		v.x += 1;
		return v;
	}	
	
	public static Vector2 doPattern2(Vector2 v){
		v.x += 1;
		v.y += Math.sin(v.x/50);
		return v;
	}
	
	
	
}