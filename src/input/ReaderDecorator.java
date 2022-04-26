package input;

import java.util.List;

public abstract class ReaderDecorator implements DocumentReader{

	 private DocumentReader componentReader;
	
	public ReaderDecorator(DocumentReader componentReader) {
		this.componentReader=componentReader;
	}
	
	public List<String> read() {
		return null;
	}
	

}
