package util;

public class IntervalScheduler {
	private float ticker;
	private float delay;
	private boolean random;
	private float intervall;
	private boolean selfReset = true;

	public IntervalScheduler(float d) {
		delay = d;
		random = false;
		intervall = 10;
	}

	public IntervalScheduler() {
		this(100);
		random = false;
	}

	public void enableRandom() {
		random = true;
	}

	public void disableRandom() {
		random = false;
	}

	public void setRandomIntervall(float inter) {
		intervall = inter;
	}

	public void act() {				
			ticker++;			
	}

	public boolean isReady() {
		if(random){
		if (ticker >= delay + (Math.random() * intervall)) {
			if (selfReset) {
				ticker = 0;
			}
			return true;
		} else {
			return false;
		}
		} else {
			if(ticker >= delay){
				if(selfReset){
					ticker = 0;
				}
				return true;
			} else {
				return false;
			}
		}

	}

	public void disableSelfReset() {
		selfReset = false;
	}

	public void enableSelfReset() {
		selfReset = true;
	}

	public float getTicker() {
		return ticker;
	}

	public void setIntervall(float newIntervall) {
		delay = newIntervall;
	}

	public void reset() {
		ticker = 0;
	}

}
