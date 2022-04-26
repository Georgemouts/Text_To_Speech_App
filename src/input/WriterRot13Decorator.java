package input;

import java.util.ArrayList;
import java.util.List;

import commands.DocumentWriter;

public class WriterRot13Decorator extends WriterDecorator{

	private DocumentWriter componentWriter;
	
	public WriterRot13Decorator(DocumentWriter componentWriter) {
		super(componentWriter);
		
	}

	public void write(String token) {
		List<String> encodedContents=new ArrayList<String>();
		
		
			for (int i = 0; i < token.length(); i++) {
				if(token.charAt(i) >= 'a' && token.charAt(i) <= 'z') {
					encodedContents.add( (char) (((token.charAt(i) - 'a' + 13)%26) + 'a')+"");
				}
				else if(token.charAt(i) >= 'A' && token.charAt(i) <= 'Z') {
					encodedContents.add( (char) (((token.charAt(i) - 'A' + 13)%26) + 'A')+"");
				}
			}//end  for
		
		
		componentWriter.write(encodedContents);
	}
	public void setComponentWriter(DocumentWriter componentWriter) {
		this.componentWriter=componentWriter;
	}
}
