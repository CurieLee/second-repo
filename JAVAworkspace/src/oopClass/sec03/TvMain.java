package oopClass.sec03;

class Tv {
	String color;
	boolean power;
	int channel;
	
	void power() 		{	power = !power; }
	void channelUp()	{	++channel; }
	void channelDown()	{	--channel; }
}

public class TvMain {
	public static void main(String[] args) {
		Tv t = new Tv();
		
		t.color = "black";
		System.out.println("색상: " + t.color);
		
		System.out.println("전원: " + t.power);
		t.power();
		System.out.println("전원: " + t.power);
		
		t.channel = 7;
		t.channelUp();
		System.out.println("현재 채널: " + t.channel);
		t.channelDown();
		System.out.println("현재 채널: " + t.channel);
		
	}
	
}
