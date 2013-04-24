package element;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class DialougePanel {
	private String currentText;
	private Vector2 conversationPosition;
	private Vector2 namePosition;
	private String author;
	
	/**
	 * A dialouge panel originally created for the PortraitPanel pack
	 * Advance the text by calling setText()
	 * @param width
	 * @param height
	 */
	public DialougePanel(int width, int height){
		conversationPosition = new Vector2(width*0.2f,height*0.15f);
		namePosition = new Vector2(width*0.2f,height*0.19f);
		currentText = "";
		author = "";
	}
		
	public void setAuthor(String s){
		author = s;
	}
	
	public void setText(String s){
		currentText = s;
	}
	
	public void draw(BitmapFont bmf, SpriteBatch sb){		
		bmf.draw(sb, currentText, conversationPosition.x, conversationPosition.y);
		bmf.draw(sb, author, namePosition.x,namePosition.y);
	}
}
