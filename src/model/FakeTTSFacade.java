package model;

import java.util.List;

public class FakeTTSFacade {
	

	private String string;
	private float volume;
	private int rate;
	private int pitch;
	
	public FakeTTSFacade() {
		
	}
	
	public void play(List<String>	contents) {
		// TODO Auto-generated method stub
		this.string = string;
	}
	
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		this.volume =  (volume/(float)100.0);
	}

	
	public void setPitch(int pitch) {
		// TODO Auto-generated method stub
		this.pitch = pitch;
	}

	public void setRate(int rate) {
		// TODO Auto-generated method stub
		this.rate = rate;
	}
	
	public String getString() {
		
		return this.string;
	}
}
