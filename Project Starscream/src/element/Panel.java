package element;

import java.awt.Dimension;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Panel {	
	private Sprite sprite;	
	
	/**
	 * A Panel with correct dimension for the game. Send in the size of the application to get it right.
	 * Originally created for the PortraitPanel pack
	 * @param Width
	 * @param Height
	 */
	public Panel(int Width, int Height){				
		sprite = new Sprite(new Texture(Gdx.files.internal("Panel.png")));
		sprite.setBounds(0,0,Width,(int)(Height*0.2));				
	}
	
	public Panel(Dimension dim){
		this(dim.width,dim.height);
	}
	
	public Sprite getSprite(){		
		return sprite;
	}
	
	
	
}
