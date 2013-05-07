package ai;

import java.util.ArrayList;
import java.util.Scanner;

import org.lwjgl.util.Point;

import util.TextLoader;
import entities.Enemy;

public class Gravity {
	ArrayList<Point> gravPoints = new ArrayList();
	ArrayList<Point> degravPoints = new ArrayList();
	public static double K = 0.015;

	public Gravity() {
		TextLoader tl = new TextLoader("GravityPoints");
		String[] l = tl.getLines();
		Scanner sc = new Scanner(l[0]);
		int i = 0;
		while(sc.hasNextInt()){
			int x = sc.nextInt();			
			sc.next();
			int y = sc.nextInt();
			gravPoints.add(new Point(x,y));
			if(sc.hasNext()){
				sc.next();
			}
		}		
		if(l.length > 1){
			sc = new Scanner(l[1]);		
		i = 0;
		while(sc.hasNextInt()){
			int x = sc.nextInt();
			sc.next();
			int y = sc.nextInt();
			degravPoints.add(new Point(x,y));
			if(sc.hasNext()){
				sc.next();
			}
		}			
		}
	}

	public void moveEnemy(Enemy e) {
		for (int i = 0; i < gravPoints.size(); i++) {
			int dx = (int) (gravPoints.get(i).getX() - e.position.x);
			int dy = (int) (gravPoints.get(i).getY() - e.position.y);
			double VectorLength = Math.sqrt(dx * dx + dy * dy);
			e.velocity.add((float) (dx * K / VectorLength),
					(float) (dy * K / VectorLength));
		}
		for (int i = 0; i < degravPoints.size(); i++) {
			int dx = (int) (degravPoints.get(i).getX() - e.position.x);
			int dy = (int) (degravPoints.get(i).getY() - e.position.y);
			double VectorLength = Math.sqrt(dx * dx + dy * dy);
			e.velocity.add((float) (dx * -K / VectorLength),
					(float) (dy * -K / VectorLength));
		}
	}

}
