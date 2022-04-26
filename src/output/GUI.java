package output;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{

	private JFrame frame = new JFrame();//Create new frame.
	private JPanel panel = new JPanel();//Create new panel.
	
	//Create all the button we need.
	private JButton openFileButton = new JButton("Open file.");
	private JButton editFileButton = new JButton("Edit file.");
	private JButton textToSpeechButton = new JButton("Listen the text.");

	
	public static void main(String[] args) {
		new GUI();
	}

	
	public GUI() {
		
		
		//Customizing our frame and creating a panel.
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		
		
		
		
		//Adding buttons to the panel.
		panel.add(openFileButton);
		panel.add(editFileButton);
		panel.add(textToSpeechButton);
		
		openFileButton.addActionListener(this);
		editFileButton.addActionListener(this);
		textToSpeechButton.addActionListener(this);
		
		frame.setSize(600,600);
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our Document Editor/Audio Text");
		frame.setVisible(true);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == openFileButton ) {
			OpenFileGUI openfileGUI = new OpenFileGUI();
		}
		else if(e.getSource() == editFileButton){
			EditFileGUI editfileGUI = new EditFileGUI();

		}
		else if(e.getSource() == textToSpeechButton ){
			TextToSpeechGUI textToSpeechGUI = new TextToSpeechGUI();

		}
		else {
			System.exit(-1);
		}
	}
}
