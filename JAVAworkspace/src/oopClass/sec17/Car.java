package oopClass.sec17;

public class Car {
	private int speed;
	private boolean stop; // boolean default false
	
	public void setSpeed(int speed) {		
		if (speed <0)
			this.speed = 0;
		else
			this.speed = speed; 
	}
	public int getSpeed() 			{		return speed; }
	
	public void setStop(boolean stop) {		
		this.stop = stop;
		this.speed = 0;
	}
	public boolean isStop() 			{		return stop; }
}
