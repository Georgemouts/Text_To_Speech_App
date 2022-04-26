package output;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.poi.hslf.record.Document;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class SaveFileGUI implements ActionListener {

	
	private String filepath;
	private JTextArea display;
	private JButton saveButton;
	
	public SaveFileGUI(String filepath) {
		this.filepath=filepath;
	}
	
	public void run() {
		
		
		JFrame frame= new JFrame();
		display = new JTextArea();
		JPanel panel = new JPanel();//Create new panel.
		saveButton = new JButton("Save");
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(saveButton);
		panel.add(display);
		saveButton.addActionListener(this);
		
		
		frame.setSize(500,300);
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle(" SHOW CONTENTS. ");
		frame.setVisible(true);
		
		
	
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == saveButton) {		
			try {
				String str=this.display.getText();

				XWPFDocument  doc = new  XWPFDocument();
				XWPFParagraph  para=doc.createParagraph();
				XWPFRun run =  para.createRun();
				run.setText(str);
						
				writeToFile(doc);
				doc.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
		}
	}
	
	public void writeToFile(XWPFDocument doc) {
		FileOutputStream out;
		try {
			out = new  FileOutputStream(new File (this.filepath));
			doc.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
