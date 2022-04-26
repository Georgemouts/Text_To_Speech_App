package commands;


import java.awt.event.ActionEvent;
import java.util.*;

import model.Document;

public class CommandFactory {

	public CommandFactory() {
		
	}
	
	
	
	
	public ActionListener createCommand(String command,ActionEvent e) { //creates a ActionListener event.
		
		if(command=="open") {
			//create an object and call the right function.
			OpenDocument openDoc = new OpenDocument();
			
			return openDoc;
		}
		else if(command=="edit"){
			//create an abject and call the right function.
			SaveDocument writeDoc = new SaveDocument();
			return writeDoc;
		}
		else if(command == "save") {
			SaveDocument saveDoc=new SaveDocument();
			return saveDoc;
		}
		else if(command == "listen") {
			DocumentToSpeech documentToSpeech =new DocumentToSpeech(); 
			return documentToSpeech ;
		}
		else {
			System.out.print("Wrong command!");
			System.exit(-1);
		}
		return null;
		
	}
}
