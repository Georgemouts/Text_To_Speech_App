package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import commands.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Document;
	
class OpenDocumenttest {
	private static CommandFactory commandFactory;
	private static commands.ActionListener OpenDocument;
	private static Document documentExcel,documentWord;
	
	static void setUp() throws Exception {
		
		commandFactory= new CommandFactory();
		OpenDocument = commandFactory.createCommand("open",null);//object type is OpenDocument
		OpenDocument .setDocument(documentWord);
		OpenDocument .actionPerformed(null);
		OpenDocument.setDocument(documentExcel);
		OpenDocument.actionPerformed(null);
	}
	
	@Test
	void testActionPerformed() {
		
		String textWord="Hellow world!";
		//String textExcel="Have 	a 	nice 	afternoon	sir \r\n"+ "";
		this.documentWord = new Document("C:\\Users\\nikos\\texnologia\\word.docx");
		//this.documentExcel= new Document("C:\\Users\\nikos\\texnologia\\excel.xlsx");
		
		try {
			documentWord.open();
			//documentExcel.open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> contentsWord = documentWord.getContents();
		//List<String> contentsExcel = documentExcel.getContents();
		//System.out.print(contentsExcel.toString());
		String text = "";
		
		for(int i = 0; i < contentsWord.size(); i++) {
			text = text + contentsWord.get(i).toString() + "\n";
		}
		text = text.stripTrailing();
		assertEquals(text, textWord);
		
		/*text="";
		for(int i = 0; i < contentsExcel.size(); i++) {
			text = text + contentsExcel.get(i).toString() + "\n";
		}
		
		text = text.stripTrailing();
		assertEquals(textExcel, text);*/
	}

}
