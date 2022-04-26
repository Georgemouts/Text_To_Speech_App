package output;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import commands.CommandFactory;
import model.Document;
import javax.swing.SwingConstants;

public class EditFileGUI implements ActionListener{
	//TODO ADD SAVE BUTTON!!!!
	
	private JFrame frame = new JFrame();//Create new frame.
	private JPanel panel = new JPanel();//Create new panel.
	private JButton chooseFileButton,backButton;
	
	
	public EditFileGUI() {
		
		//Create panel & frame.
		frame = new JFrame();
		panel = new JPanel();
		//Customizing our frame and creating a panel.
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		//Create button.
		chooseFileButton = new JButton("Choose file.");
		backButton=new JButton("Back");
		//Add action to buttons
		chooseFileButton.addActionListener(this);
		backButton.addActionListener(this);
		//Adding button to panel.
		panel.add(chooseFileButton);
		panel.add(backButton);
		
		
		frame.setSize(500,300);
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle(" Edit file. ");
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) {
			this.frame.dispose();//close file chooser.

		}
		// TODO Auto-generated method stub
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
			ShowFileEditGUI gui = new ShowFileEditGUI(doc);
			gui.showContents();
			this.frame.dispose();//close file chooser.

		
		}				
	}
	
}//end of class
