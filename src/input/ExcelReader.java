package input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader implements DocumentReader{
	private String filepath;
	
	public ExcelReader(String filepath) {
		this.filepath=filepath;
	}
	
	public List<String> read(){
		List<String> contents=null;
		
		try {
			
			 contents=readFile(this.filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contents;
	}
	
	private List<String> readFile(String filePath) throws FileNotFoundException{ //Returns an ArrayList with all the contents of the file.
		List<String> contents=new ArrayList<String>();
			
		  
		
		try {

            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellType() == CellType.STRING) {
                    	contents.add(currentCell.getStringCellValue());
                        //System.out.print(currentCell.getStringCellValue() + ",");
                    }
                    else if (currentCell.getCellType() == CellType.NUMERIC) {
                    	contents.add(currentCell.getNumericCellValue()+"" ) ;
                        //System.out.print(currentCell.getNumericCellValue() + ",");
                    }
                    else {
                    	contents.add("\n");

                    }
                }//end of inner while.
                //System.out.println();

            }//end of while.
        }//end of try.
		
		catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
		catch (IOException e) {
            e.printStackTrace();
        }

    

		
		return contents;
	}// end of readfile.
	
}//end of class.
