package ai;

public class IntervalScheduler {
	public float ticker;
	public float delay;
	
	public IntervalScheduler(float d){
		delay = d;
	}
	
	public IntervalScheduler(){
		this(100);
	}
	
	public void act(){
		ticker++;
	}
	
	public boolean isReady(){
		if(ticker > delay){
			ticker = 0;
			return true;
		} else {
			return false;
		}
	}
	
}
