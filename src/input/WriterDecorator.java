package input;

import java.util.List;

import commands.DocumentWriter;

public abstract class WriterDecorator {

	private DocumentWriter componentWriter;
	
	public WriterDecorator(DocumentWriter componentWriter) {
		this.componentWriter=componentWriter;
	}
	
	public void write(String contents) {

			
	}
}
