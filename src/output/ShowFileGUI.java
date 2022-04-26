package output;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Document;
import javax.swing.SpringLayout;

import input.DocumentReader;
import input.DocumentReaderFactory;
import input.ReaderAtbashDecorator;
import input.ReaderDecorator;
import input.ReaderRot13Decorator;

import java.awt.event.ActionListener;
import java.io.IOException;

public class ShowFileGUI {

	
	private List<String> contents;
	private Document doc;
	private JButton atBashEncodeButton,rot13EncodeButton,withOutEncodeButton;
	private JTextArea text;
	
	public ShowFileGUI(Document doc) {
		this.doc=doc;
		this.contents=doc.getContents();
		
	}

	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void showContents() {
		
		JFrame frame= new JFrame();
		JPanel panel = new JPanel();//Create new panel.
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		
		
        text = new JTextArea();
        panel.add(text);
		
		frame.setSize(586,300);
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.NORTH, text, -20, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, text, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, text, 158, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, text, -10, SpringLayout.EAST, panel);
		panel.setLayout(sl_panel);
		
		//Create buttons.
		atBashEncodeButton = new JButton("At Bash Encode");
		sl_panel.putConstraint(SpringLayout.WEST, atBashEncodeButton, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, atBashEncodeButton, -10, SpringLayout.SOUTH, panel);
		panel.add(atBashEncodeButton);
		
		rot13EncodeButton = new JButton("Rot13 Encode");
		sl_panel.putConstraint(SpringLayout.WEST, rot13EncodeButton, 37, SpringLayout.EAST, atBashEncodeButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, rot13EncodeButton, -10, SpringLayout.SOUTH, panel);
		panel.add(rot13EncodeButton);
		
		withOutEncodeButton = new JButton("Without Encode");
		sl_panel.putConstraint(SpringLayout.NORTH, withOutEncodeButton, 0, SpringLayout.NORTH, atBashEncodeButton);
		sl_panel.putConstraint(SpringLayout.WEST, withOutEncodeButton, 41, SpringLayout.EAST, rot13EncodeButton);
		panel.add(withOutEncodeButton);
		
		//Add action to each button.
		atBashEncodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				DocumentReaderFactory documentReadeFactory =new DocumentReaderFactory();
				DocumentReader reader = documentReadeFactory.createReader(doc.getFilepath());
				 
				doc.setDocReaderFactory(documentReadeFactory);
				
				ReaderAtbashDecorator readerDecorator = new ReaderAtbashDecorator(reader);
				readerDecorator.setComponentReader(reader);
				List<String> encodedContents =readerDecorator.read();
	
				String val="";
		        for(int i=0;i<encodedContents.size();i++) {

		            val=val+"  "+encodedContents.get(i);
		            if(i%40==0 && i!=0) {
		            	val+="\n";
		            	
		            }

		        }
		        text.setText(val);
		        panel.add(text);
				
				}
				
				
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		rot13EncodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DocumentReaderFactory documentReadeFactory =new DocumentReaderFactory();
					DocumentReader reader = documentReadeFactory.createReader(doc.getFilepath());
					 
					doc.setDocReaderFactory(documentReadeFactory);
					
					ReaderRot13Decorator readerDecorator = new ReaderRot13Decorator(reader);
					readerDecorator.setComponentReader(reader);
					List<String> encodedContents =readerDecorator.read();
		
					String val="";
			        for(int i=0;i<encodedContents.size();i++) {

			            val=val+"  "+encodedContents.get(i);
			            if(i%40==0) {
			            	val+="\n";
			            	
			            }

			        }
			        text.setText(val);
			        panel.add(text);
					
					}
					
					
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		
		withOutEncodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String val="";
			        for(int i=0;i<contents.size();i++) {
			            val=val+"  "+contents.get(i);
			        }
			        text.setText(val);
			        panel.add(text);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle(" SHOW CONTENTS. ");
		frame.setVisible(true);
		
		
		
	}
	
}
