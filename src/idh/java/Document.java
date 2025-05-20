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
     * Berechnet die Type-Token-Relation (TTR) des Dokuments.
     * @return TTR als double, 0 wenn keine Tokens vorhanden.
     */
    public double ttr() {
        Set<String> types = new HashSet<>();
        int tokenCount = 0;
        for (String token : this) {
            types.add(token);
            tokenCount++;
        }
        if (tokenCount == 0) {
            return 0.0; // Division durch Null vermeiden
        }
        return (double) types.size() / tokenCount;
    }

    public static final void main(String[] args) throws IOException {
        Document d = Document.readFromFile(new File("data/dracula.txt"));

        // Beispiel zur Ausgabe der TTR
        double ttr = d.ttr();
        System.out.println("TTR: " + ttr);
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


