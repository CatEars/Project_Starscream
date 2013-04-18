package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class GameScreen implements Screen {
	MainGame game;
	PaintMaster paintmaster;
	SpriteBatch spriteBatch;
	ShapeRenderer shapeBatch;
	
	public GameScreen(){
		game = new MainGame(this);
		paintmaster = new PaintMaster(game);		
		spriteBatch = new SpriteBatch();
		shapeBatch = new ShapeRenderer();
		Gdx.input.setInputProcessor(game.getInputMaster());
		
		game.initialize();
		paintmaster.initialize();
	}
	
	public void dispose() {
		
	}

	@Override
	public void hide() {

		
	}

	@Override
	public void pause() {

		
	}

	@Override
	public void render(float arg0) {
		if(!game.isLost()){
		Gdx.gl.glClearColor(.3f, .3f, .3f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		game.act();				
		paintmaster.paintAll();
		}
	}

	@Override
	public void resize(int arg0, int arg1) {
		game.resize(arg0, arg1);		
	}

	@Override
	public void resume() {

		
	}

	@Override
	public void show() {
				
	}

	public SpriteBatch getSpriteBatch() {		
		return spriteBatch;
	}

	public ShapeRenderer getShapeRenderer() {		
		return shapeBatch;
	}

}
