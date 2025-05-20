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
	
	public String getDocumentText() {
		return documentText;
	}

	public void setDocumentText(String documentText) {
		this.documentText = documentText;
	}
	public double ttr() {
	       Set<String> uniqueTokens = new HashSet<>();
	       int totalTokens = 0;
	        
	       // Durchlaufe alle Tokens und zähle sie
	       for (String token : this) {
	           uniqueTokens.add(token);  // fügt nur einzigartige Tokens hinzu
	           totalTokens++;            // erhöht den Zähler für Tokens
	        }
	        
	        // Berechne die TTR, wobei wir sicherstellen, dass totalTokens > 0 ist
	        return totalTokens > 0 ? (double) uniqueTokens.size() / totalTokens : 0.0;
	  }
	
	public static final void main(String[] args) throws IOException {
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		
		// Berechne und gebe die TTR des Textes aus
        System.out.println("Die TTR des Textes ist: " + d.ttr());
        
		int i = 0;
		for (String token : d) {
			System.out.println(i++ + ": " + token + " ");
			if (i > 100)
				break;
		}
		
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			StringTokenizer tokenizer = new StringTokenizer(documentText);
			
			@Override
			public boolean hasNext() {
				return tokenizer.hasMoreTokens();
			}

			@Override
			public String next() {
				return tokenizer.nextToken();
			}
			
		};
	}
	
	
}
