package game;

import util.IntervalScheduler;

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
	IntervalScheduler endIS;
	public GameScreen() {
		game = new MainGame(this);
		paintmaster = new PaintMaster(game);
		spriteBatch = new SpriteBatch();
		shapeBatch = new ShapeRenderer();
		Gdx.input.setInputProcessor(game.getInputMaster());
		endIS = new IntervalScheduler(200);
		endIS.disableSelfReset();
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
		Gdx.gl.glClearColor(.3f, .3f, .3f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		if (!game.isLost()) {
			game.act();
			paintmaster.paintAll();
			if (game.isInterlude()) {
				paintmaster.enablePanel();
			} else {
				paintmaster.disablePanel();
			}
		} else {
			endIS.act();			
			lostGame();
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

	private void lostGame() {
		if(!endIS.isReady()){
			paintmaster.paintSelfExplosion();
		} else {
			paintmaster.paintLostScreen();
		}
	}

	public SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}

	public ShapeRenderer getShapeRenderer() {
		return shapeBatch;
	}

}
