package oopClass.sec05;

public class TvMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv[] tvArr = new Tv[3];
		
		for (int i = 0; i < tvArr.length; i++) {
			tvArr[i] = new Tv();
			tvArr[i].channel = i + 10;
		}
		
	}

}
