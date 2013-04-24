package ai;

import org.lwjgl.util.Point;

import entities.Enemy;

public class Gravity {
	Point[] gravityPoints;
	Point[] degravityPoints;
	public static double K = 0.02;

	public Gravity(Point[] gravPoints, Point[] degravPoints) {
		gravityPoints = gravPoints;
		degravityPoints = degravPoints;
	}

	public void moveEnemy(Enemy e) {
		for (int i = 0; i < gravityPoints.length; i++) {
			int dx = (int) (gravityPoints[i].getX() - e.position.x);
			int dy = (int) (gravityPoints[i].getY() - e.position.y);
			double VectorLength = Math.sqrt(dx * dx + dy * dy);
			e.velocity.add((float) (dx * K / VectorLength),
					(float) (dy * K / VectorLength));
		}
		for (int i = 0; i < degravityPoints.length; i++) {
			int dx = (int) (degravityPoints[i].getX() - e.position.x);
			int dy = (int) (degravityPoints[i].getY() - e.position.y);
			double VectorLength = Math.sqrt(dx * dx + dy * dy);
			e.velocity.add((float) (dx * -K / VectorLength),
					(float) (dy * -K / VectorLength));
		}
	}

}
