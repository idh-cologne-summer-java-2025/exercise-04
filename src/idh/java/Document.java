package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Document implements Iterable<String> {
	String documentText;

	// Liest den gesamten Inhalt einer Datei ein und erstellt ein Document-Objekt
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

	/**
	 * 
	 * 
	 * Die Methode zählt alle Tokens und speichert sie gleichzeitig in einem Set, 
	 * das automatisch doppelte Wörter entfernt. Die TTR ergibt sich dann aus:
	 * Anzahl einzigartiger Wörter / Gesamtanzahl Tokens
	 */
	public double ttr() {
		Set<String> types = new HashSet<>(); // speichert eindeutige Wörter
		int tokenCount = 0; // zählt alle Tokens

		for (String token : this) { // nutzt den Iterator des Dokuments
			tokenCount++;
			types.add(token.toLowerCase()); // normalisiert auf Kleinbuchstaben
		}	
		if (tokenCount == 0) return 0.0; // Vermeidung durch 0
		return (double) types.size() / tokenCount; // Berechnung der TTR
	}
	
	public static final void main(String[] args) throws IOException {
		// TTR-Wert ausgeben
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		System.out.printf("TTR: %.4f\n", d.ttr());

		// Ausgabe der ersten 100 Tokens zum Test
		int i = 0;
		for (String token : d) {
			System.out.println(i++ + ": " + token + " ");
			if (i > 100)
				break;
		}
	}

	/**
	 * Iterator zur Tokenisierung des Texts — wird auch in ttr() verwendet.
	 */
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			StringTokenizer tokenizer = new StringTokenizer(documentText); // Standard-Tokenisierung
			
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
