package input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class WordReader implements DocumentReader {
	private String filepath;
		
	public WordReader(String filepath) {
		this.filepath=filepath;
	}
	
	public List<String> read() {
		List<String> contents=new ArrayList<String>();
        try {
            FileInputStream fis = new FileInputStream(this.filepath);
            //System.out.println(file.getAbsolutePath());

            XWPFDocument document1 = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document1.getParagraphs();    
            
            for (XWPFParagraph para : paragraphs) {
            	contents.add(para.getText());     
            }
            fis.close();
        	} 
        catch (Exception e) {
            //e.printStackTrace();
        }

        return contents;
	}
	
	
	private List<String> readFile(String filePath) throws FileNotFoundException{

		File file = new File(filePath);
		List<String> contents=new ArrayList<String>();
        try {

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                contents.add(line);
               // System.out.println(line);
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(contents.size());

        return contents;
    }
		
}

