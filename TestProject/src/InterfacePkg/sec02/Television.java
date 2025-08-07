package InterfacePkg.sec02;

public class Television implements RemoteControl {
	private int volume;
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("TV on");
	}
	
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("TV off");
	}
	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if (RemoteControl.MAX_VOLUME < volume)
			this.volume = RemoteControl.MAX_VOLUME;
		else if (volume < RemoteControl.MIN_VOLUME)
			this.volume = RemoteControl.MIN_VOLUME;
		else this.volume = volume;
		
		System.out.println("TV volume: " + this.volume);
	}
	// default method 재정의 가능함 (선택)
	@Override
	public void setMute(boolean mute) {
		// TODO Auto-generated method stub
		if (mute)
			System.out.println("TV 무음 상태 입니다. ");
		else
			System.out.println("TV 무음 상태가 아닙니다. ");
	}
}
