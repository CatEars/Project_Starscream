package util;

public class IntervalScheduler {
	private float ticker;
	private float delay;
	private boolean random;
	private float intervall;
	
	public IntervalScheduler(float d){
		delay = d;
		random = false;
		intervall = 10;
	}
	
	public IntervalScheduler(){
		this(100);
		random = false;
	}
	
	public void enableRandom(){
		random = true;
	}
	
	public void disableRandom(){
		random = false;
	}

	public void setRandomIntervall(float inter){
		intervall = inter;
	}
	
	public void act(){
		ticker++;
	}
	
	public boolean isReady(){
		if(ticker > delay + (Math.random()* intervall)){
			ticker = 0;
			return true;
		} else {
			return false;
		}
	}

	public void setIntervall(float newIntervall) {
		delay = newIntervall;
	}
	
	
}
