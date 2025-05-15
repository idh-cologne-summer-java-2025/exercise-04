package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

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
	
	//public static final void main(String[] args) throws IOException {
		//Document d = Document.readFromFile(new File("data/dracula.txt"));
		//int i = 0;
		//for (String token : d) {
			//System.out.println(i++ + ": " + token + " ");
			//if (i > 100)
				//break;
		//}
		
	//}
	public static final void main(String[] args) throws IOException {
	    Document d = Document.readFromFile(new File("data/dracula.txt"));

	    //  TTR berechnen und ausgeben:
	    System.out.printf("TTR: %.4f\n", d.ttr());  // Erwartet: ca. 0.1141

	    // Optional: erste 100 Tokens anzeigen
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
	// Hier beginnt die neue Methode:
	public double ttr() {
	    Set<String> types = new HashSet<>();
	    int tokenCount = 0;

	    for (String token : this) {
	        types.add(token);
	        tokenCount++;
	    }

	    if (tokenCount == 0) {
	        return 0.0;
	    }

	    return (double) types.size() / tokenCount;
	}	
	
	
}
