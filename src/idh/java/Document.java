package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.HashSet;
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
	
	/*type/token
	1) token zählen
    2) types zählen --> ist der token schon vorgekommen? wenn nein, = type, wenn ja = nicht mitzählen*/
	public double ttr() {
		int itokens = 0;
		int itype = 0;
		Set<String> uniqueToken = new HashSet<>();
		for (String token : this) {
			itokens++;
			if (!uniqueToken.contains(token)) { 
				itype++;
			}
			uniqueToken.add(token);
			

		}
		double i = (double)itype/(double)itokens;
		return i;
	}

	
	public static final void main(String[] args) throws IOException {
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		System.out.println(d.ttr());
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
