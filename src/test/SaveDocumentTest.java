package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.CommandFactory;
import commands.DocumentWriter;
import commands.DocumentWriterFactory;
import model.Document;

class SaveDocumentTest {
	private static Document doc;
	private static List<String> newContents;
	
	@BeforeAll
	static void setUp() throws Exception {
		doc=new Document("C:\\Users\\nikos\\texnologia\\word.docx");
		CommandFactory commandFactory = new CommandFactory();
		commands.ActionListener saveDocument = commandFactory.createCommand("save",null);//object type is SaveDocument
		
		newContents= new ArrayList();
		newContents.add("This"); newContents.add("is"); newContents.add("a");
		newContents.add("clockwise"); newContents.add("orange");
		
		doc.setContents(newContents);
		saveDocument.setFilePath(doc.getFilepath());
		saveDocument.setDocument(doc);
		saveDocument.actionPerformed(null);
			
	}

	@Test
	public void actionPerformed() {
		List<String> contents=doc.getContents();
		assertEquals(newContents,contents);
		
	
	}

}
