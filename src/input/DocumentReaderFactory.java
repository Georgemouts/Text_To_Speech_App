package input;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.poifs.filesystem.FileMagic;
import javax.swing.*;  

public class DocumentReaderFactory {

	private ReaderAtbashDecorator readerAtbashDecorator;
	private ReaderRot13Decorator  readerRot13Decorator;
	
	public DocumentReaderFactory() {
		
	}
	
	public DocumentReader createReader(String filePath) throws IOException {
		
		String extention = FilenameUtils.getExtension(filePath);
		if(extention.equals("docx")) { // we want to open wordFile.
			WordReader wordReader = new WordReader(filePath);
			return wordReader;
		}
		else if(extention.equals("xlsx")) { // if we want to open ExcelFile.
			ExcelReader excelReader = new ExcelReader(filePath);
			return excelReader;
		}
		else if(extention.equals("txt")) { // if we want to open TxtFile.
			WordReader wordReader = new WordReader(filePath);
			return wordReader;
		}
		else { //Warning message.
			JOptionPane.showMessageDialog(null,"You can only open .docx or .xlsx file.");
			System.exit(-1);
			return null;
		}
	}
}
