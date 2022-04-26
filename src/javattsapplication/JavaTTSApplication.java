/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javattsapplication;

import com.sun.speech.freetts.*;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Ammar Mansab
 */
public class JavaTTSApplication {

    Scanner input = new Scanner(System.in);    //System.in is a standard input stream  
    //boolean option = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JavaTTSApplication menu = new JavaTTSApplication();
        menu.showMenu();
    }

    public void showMenu() {
        int option = 1;
        while (option != 0) {
            System.out.println("|==============MENU==============|");
            System.out.println("|        1. Open Word File       |");
            System.out.println("|        2. Open Exel File       |");
            System.out.println("|        3. Exit                 |");
            System.out.print("Please select option :: ");
            option = input.nextInt();

            // Switch construct
            switch (option) {
                case 1:
                    System.out.println("Option 1 selected");
                    Wordreader wr = new Wordreader();
                    wr.menu();
                    break;
                case 2:
                    System.out.println("Option 2 selected");
                    ExcelReader exr = new ExcelReader();
                    exr.menu();
                    break;
                case 0:
                    System.out.println("Exit selected");
                    break;
                default:
                    System.out.println("Invalid selection");
                    break; // This break is not really necessary
            }
        }
    }

    void fun() {
        Model model = new Model();
        View view = new View();
        view.setVisible(true);
        Controller controller = new Controller(model, view);
        controller.control();

        System.out.println("Hello Muhammad Ammar Mansab");
        /////////////////////////////////////////////
        Voice voice;

        VoiceManager vm = VoiceManager.getInstance();

        voice = vm.getVoice("kevin");

        voice.allocate();
        voice.speak("Hello!What are you doing Muhammad Ammar Mansab?");
        /////////////////////////////////////////////
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph tmpParagraph = document.createParagraph();
        XWPFRun tmpRun = tmpParagraph.createRun();
        tmpRun.setText("LALALALAALALAAAA");
        tmpRun.setFontSize(18);
        try {
            document.write(new FileOutputStream(new File("TTS_Document_Word.docs")));
        } catch (IOException ex) {
            Logger.getLogger(JavaTTSApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.close();
        } catch (IOException ex) {
            Logger.getLogger(JavaTTSApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
