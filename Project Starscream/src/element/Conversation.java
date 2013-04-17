package element;

public class Conversation {
	String[] s = {"Hello?","Is anyone there?"};
	private int index = 0;	
	
	public Conversation(){
		
	}
	
	/**
	 * returns the text of the current conversation
	 * @return
	 */
	public String getCurrentConPiece(){
		if(index < s.length){
			return s[index];
		} else {
			return "";
		}
	}
	
	/**
	 * Enters the next part of the conversation
	 */
	public void advanceText(){
		index++;
	}
	
	public boolean hasEnded(){
		if(index >= s.length){
			return true;
		} else {
			return false;
		}		
	}
}
