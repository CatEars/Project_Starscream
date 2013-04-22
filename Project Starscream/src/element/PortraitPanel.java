package element;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PortraitPanel {
	private Panel panel;
	private Portrait portrait; 
	private DialougePanel dialouge;
	
	public PortraitPanel(int width, int height){
		panel = new Panel(width, height);
		portrait = new Portrait(width,height);
		dialouge = new DialougePanel(width,height);
	}
	
	public void updateText(String s){
		dialouge.setText(s);
	}
	
	public void draw(SpriteBatch sb,BitmapFont bmf){
		Sprite s = panel.getSprite();
		s.draw(sb);
		s = portrait.getSprite();
		s.draw(sb);		
		dialouge.draw(bmf, sb);
	}

}
