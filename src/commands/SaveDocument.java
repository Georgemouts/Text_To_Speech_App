package commands;



import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import model.*;
import output.SaveFileGUI;
import output.ShowFileEditGUI;

public class SaveDocument implements ActionListener {
	
	private Document document;
	private String filepath;
	private List<String>  newContents;
	
	
	public SaveDocument() {
		
	}
	public void setNewContents(List<String> newContents) {
		this.newContents=newContents;
	}
	public void setDocument(Document doc) {
		this.document=doc;
	}
	
	
	public String getFilepath() {
		return this.filepath;
	}
	
	void setReplayManager(ReplayManager replayManagaer) {
		
	}

	@Override
	public void setFilePath(String filepath) {
		this.filepath=filepath;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		DocumentWriterFactory documentWriterFactory = new DocumentWriterFactory();//create factory fro writers.
		
		this.document.setDocWriterFactory(documentWriterFactory);
		this.document.save();//call save function.
		
	}
	
	@Override
	public void setReplayManager() {
		
		
	}

	

	

}
