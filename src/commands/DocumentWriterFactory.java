package commands;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.io.FilenameUtils;

import input.DocumentReader;
import input.ExcelReader;
import input.ReaderAtbashDecorator;
import input.ReaderRot13Decorator;
import input.WordReader;

public class DocumentWriterFactory {
	
	private ReaderAtbashDecorator readerAtbashDecorator;
	private ReaderRot13Decorator  readerRot13Decorator;
	
	public DocumentWriterFactory() {
		
	}
	
	public DocumentWriter createWriter(String filePath) throws IOException {
		
		String extention = FilenameUtils.getExtension(filePath);
		if(extention.equals("docx")) { // we want to open wordFile.
			WordWriter wordWriter = new WordWriter(filePath);
			return wordWriter;
		}
		else if(extention.equals("xlsx")) { // if we want to open ExcelFile.
			ExcelWriter excelWriter = new ExcelWriter(filePath);
			return excelWriter;
		}
		
		else { //Warning message.
			JOptionPane.showMessageDialog(null,"You can only open .docx or .xlsx file .");
			System.exit(-1);
			return null;
		}
	}
}
