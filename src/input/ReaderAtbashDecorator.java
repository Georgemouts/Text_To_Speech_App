package input;

import java.util.ArrayList;
import java.util.List;

public class ReaderAtbashDecorator extends ReaderDecorator {
	
	private DocumentReader componentReader;
	
	public ReaderAtbashDecorator(DocumentReader componentReader) {
		super(componentReader);
	
	}

	public void setComponentReader(DocumentReader componentReader) {
		this.componentReader= componentReader;
	}
	
	public List<String> read() {
		List<String> contents,encodedContents;
		contents= componentReader.read();
		encodedContents=new ArrayList<String>();
        System.out.print("cont"+contents.toString());


		for(String token:contents) {
	        for (int i = 0; i < token.length(); i++) {
				if(token.charAt(i) >= 'a' && token.charAt(i) <= 'z') {
					encodedContents.add( (char) ('z' - token.charAt(i) + 'a')+"");
				}
			}
		}
        System.out.print("enc"+encodedContents.toString());

		return encodedContents;
	}

}
