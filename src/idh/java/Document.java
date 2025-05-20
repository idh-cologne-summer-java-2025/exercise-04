package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Document implements Iterable<String> {
	String documentText;

	public static Document readFromFile(File f) throws IOException {
		FileReader fileReader = new FileReader(f);
		int ch;
		StringBuilder b = new StringBuilder();
		while( (ch = fileReader.read()) != -1 ) {
			b.append((char) ch);
		}
		fileReader.close();
		Document doc = new Document();
		doc.documentText = b.toString();
		
		return doc;
	}
	
	public String getDocumentText() { //gibt den gespeicherten Text zurück
		return documentText;
	}

	public void setDocumentText(String documentText) { //setzt den gespeicherten Text auf einen neuen Wert
		this.documentText = documentText;
	}
	
	
	
	
	
	public double ttr() {
		Set<String> types = new HashSet<>(); //Set anlegen, um jedes Wort nur ein einziges Mal, egal wie oft es vorkommt, zu speichern (in Variable type)
		int count = 0;  //Zähler anlegen
		
		for (String token : this) { //über alle Wörter gehen
			types.add(token); //Jedes Wort wird ins Set eingefügt (types.add(token) – doppelte Wörter werden ignoriert
			count++;
		}
		
		return (double) types.size()/count;
	}
	
	
	
	
	public static final void main(String[] args) throws IOException {
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		
		int i = 0;  //Geht durch die ersten 100 Wörter (Tokens) und gibt sie mit einer Nummer aus
		for (String token : d) {  //man kann mit for(String token : d) durch die Wörter des Dokuments gehen. d -> Objekt der Klasse Document
			System.out.println(i++ + ": " + token + " ");
			if (i > 100)
				break;
		}
		
		double ttrValue = d.ttr();
		System.out.println("The TTR is " + ttrValue);
		
	}
	

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			StringTokenizer tokenizer = new StringTokenizer(documentText);
			
			@Override
			public boolean hasNext() { //prüft, ob noch ein Wort übrig ist
				return tokenizer.hasMoreTokens();
			}

			@Override
			public String next() { //gibt das nächste Wort zurück
				return tokenizer.nextToken();
			}
			
		};
	}
	
	
}
