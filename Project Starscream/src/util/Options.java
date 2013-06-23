package util;

public class Options {
	private String difficulty; //EASY, NORMAL, HARD
	
	public Options(){
		setDefaults();
	}
	
	public void setDifficulty(String dif){
		difficulty = dif;		
	}
	
	void setDefaults(){
		difficulty = "NORMAL";
	}	
	
}
