package output;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import model.Document;
import model.TTSFacade;

import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class VoiceGUI {

	private JFrame frame;
	private Document document;
	private JTextField rateField,volumeField,pitchField;
	private JLabel pitchLabel,rateLabel,volumeLabel;
	private JButton listenButton;
	private JTextArea contentsTextArea;
	
	
	
	
	
	public VoiceGUI(Document document) {
		this.document=document;

		
		frame= new JFrame("Listen the text");
		
		
		
		frame.setSize(214,381);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle(" OPEN FILE. ");
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		//create listeButton and add actionListener.
		listenButton = new JButton("Listen");
		listenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listen();
			}
		});
		frame.getContentPane().add(listenButton);
		
		//create label and textField for pitch.
		pitchLabel = new JLabel("Pitch:");
		springLayout.putConstraint(SpringLayout.NORTH, pitchLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, pitchLabel, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(pitchLabel);
		
		pitchField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, listenButton, 0, SpringLayout.WEST, pitchField);
		springLayout.putConstraint(SpringLayout.NORTH, pitchField, -3, SpringLayout.NORTH, pitchLabel);
		springLayout.putConstraint(SpringLayout.WEST, pitchField, 22, SpringLayout.EAST, pitchLabel);
		frame.getContentPane().add(pitchField);
		pitchField.setColumns(10);
		
		//create label and textField for rate.
		rateLabel = new JLabel("Rate:");
		springLayout.putConstraint(SpringLayout.NORTH, rateLabel, 14, SpringLayout.SOUTH, pitchLabel);
		springLayout.putConstraint(SpringLayout.WEST, rateLabel, 0, SpringLayout.WEST, pitchLabel);
		frame.getContentPane().add(rateLabel);
		
		rateField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, rateField, 0, SpringLayout.NORTH, rateLabel);
		springLayout.putConstraint(SpringLayout.WEST, rateField, 0, SpringLayout.WEST, pitchField);
		frame.getContentPane().add(rateField);
		rateField.setColumns(10);
		
		//create label and textField for volume.
		volumeLabel = new JLabel("Volume:");
		springLayout.putConstraint(SpringLayout.NORTH, volumeLabel, 23, SpringLayout.SOUTH, rateLabel);
		springLayout.putConstraint(SpringLayout.WEST, volumeLabel, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(volumeLabel);
		
		volumeField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, listenButton, 32, SpringLayout.SOUTH, volumeField);
		springLayout.putConstraint(SpringLayout.NORTH, volumeField, 0, SpringLayout.NORTH, volumeLabel);
		springLayout.putConstraint(SpringLayout.WEST, volumeField, 0, SpringLayout.WEST, pitchField);
		frame.getContentPane().add(volumeField);
		volumeField.setColumns(10);
		
		//Create textArea for the user to see what he or she hears.
		contentsTextArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, contentsTextArea, 6, SpringLayout.SOUTH, listenButton);
		springLayout.putConstraint(SpringLayout.WEST, contentsTextArea, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, contentsTextArea, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, contentsTextArea, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(contentsTextArea);
		contentsTextArea.setText(this.document.getContents().toString());
		
		frame.setSize(214,293);
		
		frame.setTitle("Listen the  Text");
		frame.setVisible(true);
			
	}
	
	
	public void listen(){
		
		//checking if pitch,rate,volume are filled by the user.If not we give them default values.
		if(this.pitchField.getText().isEmpty()) {
			this.document.getAudioManager().setPitch( 50);
		}
		else {
			this.document.getAudioManager().setPitch(Integer.parseInt(this.pitchField.getText() ) );
		}
		
		if(this.rateField.getText().isEmpty()) {
			this.document.getAudioManager().setRate(100 );

		}
		else {
			this.document.getAudioManager().setRate(Integer.parseInt(this.rateField.getText() ) );

		}
		
		if(this.volumeField.getText().isEmpty()) {
			this.document.getAudioManager().setVolume(100);
		}
		else {
			this.document.getAudioManager().setVolume(Integer.parseInt(this.volumeField.getText() ) );

		}
	
		
		this.document.playContents();
		
		

		
        
        

		
	}
}
