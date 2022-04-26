/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javattsapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 *
 * @author Ammar Mansab
 */
public class Controller 
{
    private Model model;
    private View view;
    private ActionListener actionListener;
    
    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
                          
    }
    
    public void control()
    {        
        actionListener = new ActionListener() 
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
                  readWordFile();
              }
        };  
        view.getOpenButton().addActionListener(actionListener);   
    }
    
    private void readWordFile()
    {
        try 
        {
        File file = new File("TTS_Document_Word.docs");
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());

        XWPFDocument document1 = new XWPFDocument(fis);

        List<XWPFParagraph> paragraphs = document1.getParagraphs();
        //Model model = new Model();
        //model.setRead(paragraphs);

        System.out.println("Para"+paragraphs);
        for (XWPFParagraph para : paragraphs) 
        {
          System.out.println(para.getText());
        }
        fis.close();
      } catch (Exception e) 
      {
        e.printStackTrace();
      }
    }  

}
