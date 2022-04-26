package commands;




import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

import input.DocumentReader;
import input.DocumentReaderFactory;
import model.Document;
import output.GUI;
import output.ShowFileGUI;

public class OpenDocument implements ActionListener {
	
	private String filePath;
	private Document document;
	
	public OpenDocument() {
	}
	
	public void setDocument(Document newDocument) {
		this.document=newDocument;
	}
	
	public void setReplayManager(ReplayManager replayManager) {
		
	}

	public void setFilePath(String newFilePath) {
		this.filePath=newFilePath;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.document.open();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ShowFileGUI showfile = new ShowFileGUI(this.document);
		showfile.showContents();
	}

	@Override
	public void setReplayManager() {
		// TODO Auto-generated method stub
		
	}

	

	
	
	

	
	
}
