package input;

import java.util.ArrayList;
import java.util.List;

public class ReaderRot13Decorator extends ReaderDecorator{
	
	private DocumentReader componentReader;
	
	public ReaderRot13Decorator(DocumentReader componentReader) {
		super(componentReader);
		// TODO Auto-generated constructor stub
	}

	public void setComponentReader(DocumentReader componentReader) {
		this.componentReader=componentReader;
	}
	
	public List<String> read() {
		List<String> contents,encodedContents;
		contents= componentReader.read();
		encodedContents=new ArrayList<String>();
		
		for(String token:contents) {
			for (int i = 0; i < token.length(); i++) {
				if(token.charAt(i) >= 'a' && token.charAt(i) <= 'z') {
					encodedContents.add( (char) (((token.charAt(i) - 'a' + 13)%26) + 'a')+"");
				}
				else if(token.charAt(i) >= 'A' && token.charAt(i) <= 'Z') {
					encodedContents.add( (char) (((token.charAt(i) - 'A' + 13)%26) + 'A')+"");
				}
			}//end nested fr
		
		}//end for
		
		return encodedContents;
	}//end read
}
