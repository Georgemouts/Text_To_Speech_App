package commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter implements DocumentWriter{
	
	private String filepath;

	
	public ExcelWriter(String filepath) {
		this.filepath=filepath;
	}
	
	@Override
	public void write(List<String> contents) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		try {
		workbook = new XSSFWorkbook(new FileInputStream(this.filepath) );
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		int rowCount = 0;
		int columnCount = 0;
		
		for (String i : contents) {
			Row row = sheet.createRow(rowCount++);
			Cell cell = row.createCell(columnCount);
			cell.setCellValue(i);
			
		}

		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
			try {
				FileOutputStream outputStream = new FileOutputStream(new File(this.filepath));
				workbook.write(outputStream);
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}//end of class
