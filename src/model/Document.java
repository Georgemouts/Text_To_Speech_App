package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import commands.*;
import input.*;
import output.ShowFileGUI;

public class Document {
	
	private List<String> contents;
	private TTSFacade audioManager;
	private DocumentReader documentReader;
	private DocumentReaderFactory documentReaderFactory; 
	private DocumentWriter documentWriter;
	private DocumentWriterFactory documentWriterFactory;
	private String filepath;
	private Boolean atRot13Encode,atBashEncode;
	
	//constructor 
	public Document(String filepath) {
		//this.contents=contents;
		this.filepath=filepath;
	}
	public TTSFacade getAudioManager() {
		return this.audioManager;	
	}
	
	public String getFilepath() {
		return this.filepath;
	}
	public Boolean getAtRot13() {
		return this.atRot13Encode;
	}
	public Boolean getAtBash() {
		return this.atBashEncode;
	}
	public List<String> getContents(){
		return this.contents;
	}
	public void setAudioManager(TTSFacade newAudioManager) {
		this.audioManager=newAudioManager;
	}
	
	public void setAtRot13Encode(Boolean atRot13) {
		this.atRot13Encode=atRot13;
	}
	public void setAtbash(Boolean atbash) {
		this.atBashEncode=atbash;
	}
	
	public void setDocReaderFactory(DocumentReaderFactory newDocumentReaderFactory) {
		this.documentReaderFactory=newDocumentReaderFactory;
		
	}
	
	public void setDocWriterFactory(DocumentWriterFactory newDocumentWriterFactory) {
		this.documentWriterFactory=newDocumentWriterFactory;
		
	}
	public void setReader(DocumentReader wr) {
		this.documentReader=wr;
	}
	public void setContents(List<String> contents) {
		this.contents=contents;
	}
	
	public void open() throws IOException {
		DocumentReaderFactory readerfactory=new DocumentReaderFactory();
		//System.out.println(this.filepath);
		DocumentReader wr =readerfactory.createReader(this.filepath);//create reader
		this.setDocReaderFactory(readerfactory);
		this.setReader(wr);
		this.contents=wr.read();
	}
	
	public void playContents() {
		String val="";
		for(String i : this.contents) {
			val+=i+" ";
		}
		this.audioManager.play(val);
	}
	
	public void playLine(Integer x) {
		
	}
	
	public void save() {

		try {
			
			DocumentWriter reader = this.documentWriterFactory.createWriter(this.filepath);
			reader.write(this.contents);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}// end of class.
