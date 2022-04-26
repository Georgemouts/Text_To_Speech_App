package output;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import commands.CommandFactory;
import commands.OpenDocument;
import input.DocumentReader;
import input.DocumentReaderFactory;
import input.WordReader;
import model.Document;

public class OpenFileGUI implements ActionListener {

	private JFrame frame ;
	private JPanel panel; 
	private JButton chooseFileButton;
	private JButton backButton;

	

	
	public OpenFileGUI() {
		
		//Create panel & frame.
		frame = new JFrame();
		panel = new JPanel();
		
		//Customizing our frame and creating a panel.
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		
		//Create buttons
		chooseFileButton = new JButton("Choose file.");
		backButton = new JButton("Back.");
		//Add action to button
		chooseFileButton.addActionListener(this);
		backButton.addActionListener(this);
		//Adding buttons to panel
		panel.add(chooseFileButton);
		panel.add(backButton);
		
		
		
		frame.setSize(500,300);
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle(" OPEN FILE. ");
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == backButton) {
			this.frame.dispose();//close file chooser.

		}
		
		if(e.getSource() == chooseFileButton) {
			String filepath="";
			JFileChooser fileChooser = new JFileChooser(); //Initialize fileChooser.
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); //Select where to search.
			int result = fileChooser.showOpenDialog(frame); //Open new window.
			if (result == JFileChooser.APPROVE_OPTION) { //Check if user has selected any file.
				File selectedFile = fileChooser.getSelectedFile();
				 filepath = selectedFile.getAbsolutePath(); // save filepath.
				
			}
			
			Document doc = new Document(filepath);//Create document.
			CommandFactory commandFactory = new CommandFactory();
			commands.ActionListener OpenDocument = commandFactory.createCommand("open",e);//object type is OpenDocument.
			OpenDocument.setDocument(doc);
			OpenDocument.actionPerformed(e);
			this.frame.dispose();//close file chooser.

			
			
			
		}				

		
		
	}
	public void showContents(Document doc) {
		
		ShowFileGUI showfile = new ShowFileGUI(doc);
		showfile.showContents();
	}
	

}
