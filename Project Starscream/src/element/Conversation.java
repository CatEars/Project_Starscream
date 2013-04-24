package element;

public class Conversation {
	private String speaker;
	private String[] strings;
	private int index = 1;	
	
	public Conversation(String[] dialouge){		
		speaker = dialouge[0];
		strings = dialouge;
	}
	
	/**
	 * returns the name of whomever is speaking.
	 * @return
	 */
	public String getAuthor(){
		return speaker;
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
			index = 1;
			return true;
		} else {
			return false;
		}		
	}
}
