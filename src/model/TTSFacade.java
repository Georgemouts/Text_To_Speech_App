package model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

 

public class TTSFacade {

	VoiceManager vm;
	Voice voice;
	Integer pitch,rate,volume;//default values are 50,100,100.
	
	
	public TTSFacade() {
		
	}
	
	public void play(String contents) {
		
	
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		Voice voice= VoiceManager.getInstance().getVoice("kevin16");
		//set voice parameters
		voice.setPitch(this.pitch);
		voice.setRate(this.rate);
		voice.setVolume(this.volume);
		
		voice.allocate();
        voice.speak(contents);
        voice.deallocate();
	}
	
	
	public void setVolume(Integer newVolume) {
		
			this.volume=newVolume;
		
		
	}
	
	public void setPitch(Integer newPitch) {
		
			this.pitch=newPitch;
	
	}
	
	public void setRate(Integer newRate) {
		
			this.rate=newRate;
		
	}
	
	
	
}
