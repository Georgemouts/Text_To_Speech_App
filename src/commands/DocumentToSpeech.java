package commands;



import java.awt.event.ActionEvent;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import model.*;
import output.VoiceGUI;

public class DocumentToSpeech implements ActionListener {

	private Document document;
	
	
	
	public DocumentToSpeech() {
		
	}
	
	public void setDocument(Document document) {
		this.document=document;
	}
	
	public void setReplayManager(ReplayManager replayManager) {
		
	}

	

	@Override
	public void setFilePath(String fileFilePath) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setReplayManager() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		VoiceGUI voicegui=new VoiceGUI(this.document);
		//voicegui.listen();
		
		
		
		
	}

	

	
	
}
