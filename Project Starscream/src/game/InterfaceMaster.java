package game;

import org.lwjgl.util.Dimension;

import util.TextLoader;

import element.Conversation;
import element.PortraitPanel;

public class InterfaceMaster {
	PortraitPanel currentPP;
	Conversation conv;
	Dimension appSize;
	private PaintMaster pm;
	private MainGame master;
	
	public InterfaceMaster(MainGame m){
		appSize = new Dimension(m.width,m.height);		
		conv = new Conversation(TextLoader.getLines("dialouge/Level1AdvancementText"));		
		currentPP = new PortraitPanel(appSize.getWidth(),appSize.getHeight());
		currentPP.setAuthor(conv.getAuthor());
		currentPP.updateText(conv.getCurrentConPiece());
	}

	public String getAuthor(){
		return conv.getAuthor();
	}	
	
	public void advanceText() {		
		conv.advanceText();				
	}

	public void act() {
		currentPP.updateText(conv.getCurrentConPiece());
	}

	public PortraitPanel getPortraitPanel() {
		return currentPP;
	}

	public boolean convHasEnded() {		
		return conv.hasEnded(); 
	}
}
