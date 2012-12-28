package game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameScreen implements Screen {
	MainGame game;
	PaintMaster paintmaster;
	SpriteBatch batch;
	
	public GameScreen(){
		game = new MainGame(this);
		paintmaster = new PaintMaster(game);
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
		game.act();
		batch.begin();
		paintmaster.paintAll();
		batch.end();
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
		return batch;
	}

}
