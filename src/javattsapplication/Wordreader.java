/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javattsapplication;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class Wordreader implements DocumentReader {

    //private Model model;
    Scanner input1 = new Scanner(System.in);    //System.in is a standard input stream  

    public Wordreader() {

    }

    @Override
    public void read() {
        try {
            File file = new File("TTS_Document_Word.docs");
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            XWPFDocument document1 = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = document1.getParagraphs();
            //Model model = new Model();
            //model.setRead(paragraphs);

            System.out.println("Para" + paragraphs);
            System.out.println("------------------------");
            System.out.println("Word File is...");
            for (XWPFParagraph para : paragraphs) {
                System.out.println(para.getText());
            }
            System.out.println("------------------------");
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menu() {
        int option = 1;

        while (option != 0) {
            System.out.println("|==============WORD-MENU==============|");
            System.out.println("|        1. Show File       |");
            System.out.println("|        2. Speak File      |");
            System.out.println("|        3. Edit  File      |");
            System.out.println("|        0. Exit            |");
            System.out.print("Please select option :: ");
            option = input1.nextInt();
            //input1.close();

            if(option == 1) 
            {
                read();
            }
            else if(option == 2)
            {
                speak();
            }
            else if (option == 3)
            {
                editFile();
            }
            else if (option == 0)
            {
                System.out.println("");
            }
            else
            {
                System.out.print("Wrong Input :(");
            }
        }
    }
    
    void editFile()
    {
        Scanner in = new Scanner(System.in);    //System.in is a standard input stream  
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph tmpParagraph = document.createParagraph();
        XWPFRun tmpRun = tmpParagraph.createRun();
        
        System.out.print("Please Enter Paragraphs into Word File :: ");
        
        String para = in.nextLine();
        
        
        tmpRun.setText(para);
        
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
        //input1.close();
    }
    
    void speak()
    {
        Voice voice;

        VoiceManager vm = VoiceManager.getInstance();

        voice = vm.getVoice("kevin");

        voice.allocate();
        //voice.speak("Hello!What are you doing Muhammad Ammar Mansab?");
        /////////////////////////////////////////////
        try {
            File file = new File("TTS_Document_Word.docs");
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            XWPFDocument document1 = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = document1.getParagraphs();
            //Model model = new Model();
            //model.setRead(paragraphs);

            System.out.println("Para" + paragraphs);
            System.out.println("------------------------");
            System.out.println("Word File is...");
            for (XWPFParagraph para : paragraphs) {
                System.out.println(para.getText());
                voice.speak(para.getText());
            }
            System.out.println("------------------------");
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
