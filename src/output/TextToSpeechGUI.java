package output;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import commands.CommandFactory;
import model.Document;
import model.TTSFacade;

public class TextToSpeechGUI implements ActionListener {

	
	private JFrame frame =  new JFrame();//Create new frame.
	private JPanel panel = new JPanel();//Create new panel.
	private JButton chooseFileButton;
	
	public TextToSpeechGUI() {
		

		//Customizing our frame and creating a panel.
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		
		chooseFileButton = new JButton("Choose File");
		chooseFileButton.addActionListener(this);
		panel.add(chooseFileButton);
		
		frame.setSize(500,300);
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("LISTEN THE WORDS ");
		frame.setVisible(true);
		
	}
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == chooseFileButton) {
			
			String filepath="";
			JFileChooser fileChooser = new JFileChooser(); //Initialize fileChooser.
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); //Select where to search.
			int result = fileChooser.showOpenDialog(frame); //Open new window.
			if (result == JFileChooser.APPROVE_OPTION) { //Check if user has selected any file.
				File selectedFile = fileChooser.getSelectedFile();
				filepath = selectedFile.getAbsolutePath(); // save filepath.
			}

			CommandFactory commandFactory = new CommandFactory();
			commands.ActionListener documentToSpeech =commandFactory.createCommand("listen",e); //return object type of DocumentToSpeech
			
			Document document = new Document(filepath);
			TTSFacade facade = new TTSFacade();
			//read doc's contents.
			try {
				document.open();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			document.setAudioManager(facade);
			documentToSpeech.setDocument(document);
			documentToSpeech.actionPerformed(e);
			this.frame.dispose();
		}				
		
	}//end of actionPerformed
}//end of class
