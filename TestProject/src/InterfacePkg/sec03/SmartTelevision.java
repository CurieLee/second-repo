package InterfacePkg.sec03;

// import InterfacePkg.sec02.RemoteControl;

public class SmartTelevision implements RemoteControl, iSearchable {
	private int volume;
	
	@Override
	public void search(String url) {
		// TODO Auto-generated method stub
		System.out.println(url + "을 검색합니다. ");
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Smart TV on");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Smart TV off");
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if (RemoteControl.MAX_VOLUME < volume)
			this.volume = RemoteControl.MAX_VOLUME;
		else if (volume < RemoteControl.MIN_VOLUME)
			this.volume = RemoteControl.MIN_VOLUME;
		else this.volume = volume;

		System.out.println("smart TV volume: " + this.volume);
	}

}
