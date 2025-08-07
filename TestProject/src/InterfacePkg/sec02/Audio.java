package InterfacePkg.sec02;

public class Audio implements RemoteControl {
	private int volume;
	private boolean mute;
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Audio on");
	}
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Audio off");
	}
	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if (RemoteControl.MAX_VOLUME < volume)
			this.volume = RemoteControl.MAX_VOLUME;
		else if (volume < RemoteControl.MIN_VOLUME)
			this.volume = RemoteControl.MIN_VOLUME;
		else this.volume = volume;

		System.out.println("Audio volume: " + this.volume);
	}
	
}
