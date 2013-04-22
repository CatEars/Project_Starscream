package element;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Portrait {
	private Sprite sprite;	
	
	/**
	 * A Portrait that goes with the PortraitPanel pack
	 * You can change the texture shown inside the panel by calling setTexture(); 
	 * @param Width
	 * @param Height
	 */
	public Portrait(int Width, int Height){		
		sprite = new Sprite(new Texture(Gdx.files.internal("TheOneStuff.png")));
		sprite.setBounds(0,0,Width*0.16f,Height*0.2f);
	}
	
	public void setTexture(Texture t){
		sprite.setTexture(t);
	}
	
	public Sprite getSprite(){
		return sprite;
	}
	
	
}
