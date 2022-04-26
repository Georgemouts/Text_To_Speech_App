package commands;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordWriter implements DocumentWriter {
	
	private String filepath;

	
	public WordWriter(String filepath) {
		this.filepath=filepath;
	}
	
	@Override
	public void write(List<String> contents) {

		
		try {
			XWPFDocument  doc = new  XWPFDocument();
			XWPFParagraph  para=doc.createParagraph();
			XWPFRun run =  para.createRun();
			String val="";
			for(String i : contents) {
				val+=i+" ";
			}
			run.setText(val);
			
			writeToFile(doc);
			doc.close();
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}

	
	}//end of write.

	public void writeToFile(XWPFDocument doc) {
			FileOutputStream out;
			try {
				out = new  FileOutputStream(new File (this.filepath));
				doc.write(out);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
	}// end of writeToFile.
		
}//end of class.
