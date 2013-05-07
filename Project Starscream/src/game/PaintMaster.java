package game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

import element.PortraitPanel;
import entities.Enemy;
import entities.Explosion;
import entities.HeatSeeker;
import entities.Laser;
import entities.Missile;
import entities.Player;

public class PaintMaster {
	MainGame master;
	SpriteBatch batch;
	ShapeRenderer sr;
	OrthographicCamera camera;
	EntityMaster em;
	InterfaceMaster im;
	BitmapFont bf;

	Texture endScreen = new Texture(Gdx.files.internal("GameOver.png"));
	Sprite end = new Sprite(endScreen);	
	
	Player player;
	ArrayList<Laser> laserList;
	ArrayList<Enemy> enemyList;
	ArrayList<Missile> missileList;
	ArrayList<Explosion> explosionList;
	ArrayList<HeatSeeker> heatList;

	PortraitPanel pp;

	/**
	 * PaintMaster checks all painting. During painting, it reloads everything
	 * supposed to be drawn from the game and draws it to the games spritebatch
	 * 
	 * @param Master
	 */
	public PaintMaster(MainGame Master) {
		end.setSize(600, 400);
		master = Master;
		camera = new OrthographicCamera(360, 360);
		camera.position.set(180, 180, 0);
		bf = new BitmapFont();
	}

	public void initialize() {
		batch = master.getSpritebatch();
		sr = master.getShapeRenderer();
		em = master.getEntityMaster();
		im = master.getInterfaceMaster();
		player = master.getPlayer();
		laserList = em.getLasers();
		enemyList = em.getEnemies();
		missileList = em.getMissiles();
		explosionList = em.getExplosions();
		heatList = em.getHeatSeekers();
	}

	private void paintLasers(){
		for (int i = 0; i < laserList.size(); i++) {
			Laser l = laserList.get(i);
			Sprite s = l.getSprite();
			s.draw(batch);
		}
	}
	
	private void paintPlayer(){
		Sprite playerSprite = player.getSprite();
		playerSprite.draw(batch);
		
	}
	
	private void paintHeatSeekers(){
		sr.setColor(Color.ORANGE);
		for (int i = 0; i < heatList.size(); i++) {
			HeatSeeker hs = heatList.get(i);
			Rectangle r = hs.getRect();
			sr.filledRect(r.x, r.y, r.width, r.height);
		}
	}
	
	private void paintMissiles(){
		sr.setColor(Color.CYAN);
		for (int i = 0; i < missileList.size(); i++) {
			Missile m = missileList.get(i);
			Rectangle r = m.getRectangle();
			sr.filledRect(r.x, r.y, r.width, r.height);
		}
	}
	
	private void paintEnemies(){
		for (int i = 0; i < enemyList.size(); i++) {
			Enemy e = enemyList.get(i);
			Sprite s = e.getSprite();
			s.draw(batch);
		}
	}
	
	private void paintExplosions(){
		for (int i = 0; i < explosionList.size(); i++) {
			Explosion e = explosionList.get(i);
			Sprite s = e.getSprite();
			s.draw(batch);
		}
	}
	
	private void paintPortraits(){
		batch.begin();
		if (master.isInterlude() && enemyList.size() == 0 && pp != null) {
			pp.draw(batch, bf);
		}
		batch.end();
	}
	
	private void paintPlayerInterface(){
		batch.begin();		
		bf.draw(batch, "Player HP: " + player.getHP(), 5, 20);
		bf.draw(batch, "Missiles: " + (int) player.getMissiles(), 5, 60);
		batch.end();	
		sr.begin(ShapeType.FilledRectangle);
		sr.setColor(Color.GREEN);
		sr.filledRect(5, 30, player.getEnergy(), 10);
		sr.setColor(Color.WHITE);
		sr.filledRect(5, 70, player.getMissileReadiness() * 100f, 10);
		sr.end();
	}
	
	public void paintAll() {
		/* Shaperenderer start */
		sr.begin(ShapeType.FilledRectangle);		
		paintMissiles();
		paintHeatSeekers();
		sr.end();
		/* Shaperenderer end */

		/* Spritebatch start */
		batch.begin();
		paintLasers();
		paintPlayer();
		paintEnemies(); 
		paintExplosions();
		batch.end();
		/* Spritebatch end */
		
		/*Self enabling/disabling painting */
		paintPlayerInterface();
		paintPortraits();
		/*End of self enabling/disabling painting*/
		
	}

	public void enablePanel() {
		pp = im.getPortraitPanel();
	}

	public void disablePanel() {
		pp = null;
	}

	public void paintSelfExplosion() {
		if(Math.random() > 0.8){
			explosionList.add(new Explosion((float)(player.getPosition().x + Math.random() * player.getWidth()),(float)( player.getPosition().y + Math.random()*player.getHeight())));
		}
		
		batch.begin();						
		paintLasers();
		paintEnemies();
		paintPlayer();
		paintExplosions();
		batch.end();
		
		//Explosion Act
		for (int i = 0; i < explosionList.size(); i++) {
			Explosion e = explosionList.get(i);
			e.act();
			if(e.hasExpired()){
				explosionList.remove(i);
				i--;
			}
		}		
		
	}

	public void paintLostScreen() {
		batch.begin();
		end.draw(batch);	
		batch.end();
	}
}
