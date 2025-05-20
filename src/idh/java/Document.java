package idh.java;

import java.io.*;
import java.util.*;

public class Document implements Iterable<String> {
    private String documentText;

    public static Document readFromFile(File file) throws IOException {
        try (FileReader fr = new FileReader(file);
             StringWriter sw = new StringWriter()) {
            char[] buf = new char[4096];
            int n;
            while ((n = fr.read(buf)) != -1) sw.write(buf, 0, n);
            Document doc = new Document();
            doc.documentText = sw.toString();
            return doc;
        }
    }

    public String getDocumentText() {
        return documentText;
    }

    public void setDocumentText(String text) {
        this.documentText = text;
    }

    public double ttr() {
        Set<String> types = new HashSet<>();
        int tokens = 0;
        for (String token : this) {
            tokens++;
            types.add(token);
        }
	    
        return tokens == 0 ? 0 : (double) types.size() / tokens;
    }

    @Override
    public Iterator<String> iterator() {
        return Arrays.asList(documentText.split("\\s+")).iterator();
    }

    public static void main(String[] args) throws IOException {
        Document d = Document.readFromFile(new File("data/dracula.txt"));
        System.out.println(d.ttr());
    }
}
