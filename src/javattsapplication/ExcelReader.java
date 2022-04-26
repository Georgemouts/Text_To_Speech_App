/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javattsapplication;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Ammar Mansab
 */
public class ExcelReader {

    public void menu() {
        Scanner input1 = new Scanner(System.in);    //System.in is a standard input stream  
        int option = 1;

        while (option != 0) {
            System.out.println("|==============EXCEL-MENU==============|");
            System.out.println("|        1. Show File       |");
            System.out.println("|        2. Speak File      |");
            System.out.println("|        3. Edit  File      |");
            System.out.println("|        0. Exit            |");
            System.out.print("Please select option :: ");
            option = input1.nextInt();
            //input1.close();

            if (option == 1) {
                read();
            } else if (option == 2) {
                speak();
            } else if (option == 3) {
                editFile();
            } else if (option == 0) {
                System.out.println("");
            } else {
                System.out.print("Wrong Input :(");
            }
        }
    }

    void read() 
    {
        
    }
}
