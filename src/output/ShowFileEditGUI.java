package output;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import commands.CommandFactory;
import commands.DocumentWriter;
import commands.DocumentWriterFactory;
import input.ReaderRot13Decorator;
import input.WriterAtbashDecorator;
import input.WriterRot13Decorator;
import model.Document;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;

public class ShowFileEditGUI implements ActionListener {
	
	private List<String> contents;
	private Document doc;
	private JButton saveButton,cancelButton,rot13Savebutton,saveAtbashButton;
	private JFrame frame;
	private JPanel panel;
	private JTextArea textArea;
	
	
	
	public ShowFileEditGUI(Document doc) {
		this.doc=doc;
		try {
			this.doc.open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.contents=doc.getContents();
	}

	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void showContents() {
		
		frame= new JFrame();
		panel=new JPanel();
		textArea = new JTextArea();
		
		
		frame.setSize(500,300);
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		String val="";
        for(int i=0;i<this.doc.getContents().size();i++) {

            val=val+"  "+this.doc.getContents().get(i);

        }
		textArea.setText(val);
		//Create buttons
		saveButton = new JButton("Save with no encode");
		sl_panel.putConstraint(SpringLayout.WEST, saveButton, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, saveButton, -46, SpringLayout.SOUTH, panel);
		panel.add(saveButton);
		
		cancelButton = new JButton("Cancel");
		panel.add(cancelButton);
		
		
		sl_panel.putConstraint(SpringLayout.NORTH, textArea, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textArea, -10, SpringLayout.WEST, saveButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, textArea, 158, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, panel);
		panel.add(textArea);
		
		rot13Savebutton = new JButton("Rot13 Encode");
		
		sl_panel.putConstraint(SpringLayout.NORTH, cancelButton, 6, SpringLayout.SOUTH, rot13Savebutton);
		sl_panel.putConstraint(SpringLayout.EAST, cancelButton, -10, SpringLayout.EAST, rot13Savebutton);
		sl_panel.putConstraint(SpringLayout.NORTH, rot13Savebutton, 0, SpringLayout.NORTH, saveButton);
		panel.add(rot13Savebutton);
		
		saveAtbashButton = new JButton("At Bash Encode");
		sl_panel.putConstraint(SpringLayout.EAST, rot13Savebutton, -39, SpringLayout.WEST, saveAtbashButton);
		sl_panel.putConstraint(SpringLayout.NORTH, saveAtbashButton, 0, SpringLayout.NORTH, saveButton);
		sl_panel.putConstraint(SpringLayout.EAST, saveAtbashButton, -43, SpringLayout.EAST, panel);
		panel.add(saveAtbashButton);
		
		
		//Create actions for the buttons
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str[] =textArea.getText().split(" ") ;
				
				List<String> newContents=Arrays.asList( str );//Contents to be saved.

				doc.setContents(newContents);//update document's contents.
							
				CommandFactory commandFactory = new CommandFactory();
				commands.ActionListener saveDocument = commandFactory.createCommand("save",e);//object type is SaveDocument.			
				
				saveDocument.setFilePath(doc.getFilepath());
				saveDocument.setDocument(doc);
				saveDocument.actionPerformed(e);
				
				frame.dispose();//close file chooser.
			}
		});
		
		rot13Savebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				DocumentWriterFactory documentWriterFactory = new DocumentWriterFactory();
				DocumentWriter writer =documentWriterFactory.createWriter(doc.getFilepath());
				
				WriterRot13Decorator writerDecorator = new WriterRot13Decorator(writer);
				writerDecorator.setComponentWriter(writer);
				
				writerDecorator.write(textArea.getText());
				
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();//close file chooser.
			}
		});
		
		saveAtbashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DocumentWriterFactory documentWriterFactory = new DocumentWriterFactory();
					DocumentWriter writer =documentWriterFactory.createWriter(doc.getFilepath());
					
					WriterAtbashDecorator writerDecorator = new WriterAtbashDecorator(writer);
					writerDecorator.setComponentWriter(writer);
					writerDecorator.write(textArea.getText());
					
				}
				catch(Exception e2) {
					e2.printStackTrace();
				}
				
				frame.dispose();//close file chooser.
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle(" SHOW CONTENTS. ");
		frame.setVisible(true);
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		}
	}
	

	

