package element;

public class Conversation {
	private String[] strings;
	private int index = 0;	
	
	public Conversation(String[] conversation){
		strings = conversation;
	}
	
	/**
	 * returns the text of the current conversation
	 * @return
	 */
	public String getCurrentConPiece(){
		if(index < strings.length){
			return strings[index];
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
		if(index >= strings.length){
			return true;
		} else {
			return false;
		}		
	}
}
