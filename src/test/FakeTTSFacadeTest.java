package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Document;
import model.FakeTTSFacade;

class FakeTTSFacadeTest {
	private static FakeTTSFacade faketts;
	private static Document doc;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		faketts = new FakeTTSFacade();
		faketts.setPitch(22);
		faketts.setRate(100);
		faketts.setVolume(112);
		doc=new Document("C:\\Users\\nikos\\texnologia\\word.docx");
		doc.open();
		faketts.play(doc.getContents());
	}
		
	@Test
	void play() {
		String text="This is a clockwise orange";
		assertEquals(text,doc.getContents());
	}

}
