package element;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class DialougePanel {
	private String currentText;
	private Vector2 position;
	
	/**
	 * A dialouge panel originally created for the PortraitPanel pack
	 * Advance the text by calling setText()
	 * @param width
	 * @param height
	 */
	public DialougePanel(int width, int height){
		position = new Vector2(width*0.2f,height*0.15f);
		currentText = "";
	}
		
	public void setText(String s){
		currentText = s;
	}
	
	public void draw(BitmapFont bmf, SpriteBatch sb){		
		bmf.draw(sb, currentText, position.x, position.y);
	}
}
