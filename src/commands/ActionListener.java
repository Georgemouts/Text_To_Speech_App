package commands;

import java.awt.event.ActionEvent;

import model.Document;

public interface ActionListener {

	public void actionPerformed(ActionEvent e);
	public void setFilePath(String fileFilePath);
	public void setDocument(Document newDocument);
	public void setReplayManager();
}