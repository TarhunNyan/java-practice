package multhiThreading.util.random;

import java.util.Random;

public class RandomBetween {
	
	private final Random random;
	private       int    min;
	private       int    max;
	private       long   value;
	
	RandomBetween( ) {
		initRange(1, 5);
		this.random = new Random( );
	}
	
	public RandomBetween(int min, int max) {
		if(min<max) { initRange(min, max); }
		if(max<min) { initRange(max, min); }
		this.random = new Random( );
	}
	
	public long newRandomValue( ) {
		this.value = random.nextLong(this.min, this.max);
		return this.value;
	}
	
	public long getRandomValue( ) {
		return value;
	}
	
	public int getMin( ) { return this.min; }
	
	public void setMin(int min) { this.min = min; }
	
	public int getMax( ) { return this.max; }
	
	public void setMax(int max) { this.max = max; }
	
	private void initRange(int min, int max) {
		this.min = min * 100;
		this.max = max * 100;
		this.value = 0;
	}
	
}
