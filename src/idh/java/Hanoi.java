
package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Hanoi {

    private Stack<Integer> left;
    private Stack<Integer> middle;
    private Stack<Integer> right;
    private static final int NUM_DISCS = 3;

    public Hanoi() {
        left = new Stack<>();
        middle = new Stack<>();
        right = new Stack<>();
        for (int i = NUM_DISCS; i >= 1; i--) {
            left.push(i);
        }
    }

    private void movePiece(char from, char to) {
        Stack<Integer> source = getStack(from);
        Stack<Integer> target = getStack(to);

        if (source.isEmpty()) {
            System.out.println("Source stack is empty.");
            return;
        }

        int piece = source.peek();
        if (!target.isEmpty() && target.peek() < piece) {
            System.out.println("Cannot place bigger piece on smaller one.");
            return;
        }

        source.pop();
        target.push(piece);
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(this);
                System.out.print("Enter source and target stick (will move top piece): ");
                String s = br.readLine();
                if (s.matches("^([lmr])([lmr])$")) {
                    char source = s.charAt(0);
                    char target = s.charAt(1);
                    movePiece(source, target);
                } else {
                    System.out.println("Invalid input. Please use letters: l, m, r.");
                }
            } catch (Exception e) {
                System.out.println("Try again, something's not right.");
            }
        }
    }

    private Stack<Integer> getStack(char c) {
        switch (c) {
            case 'l': return left;
            case 'm': return middle;
            case 'r': return right;
            default: throw new IllegalArgumentException("Invalid stick: " + c);
        }
    }

    private Iterator<Integer> getLeftDescendingIterator() {
        return new ArrayList<>(left).iterator();
    }

    private Iterator<Integer> getMiddleDescendingIterator() {
        return new ArrayList<>(middle).iterator();
    }

    private Iterator<Integer> getRightDescendingIterator() {
        return new ArrayList<>(right).iterator();
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("  |\n l|");
        Iterator<Integer> iter = this.getLeftDescendingIterator();
        while (iter.hasNext()) {
            b.append(iter.next()).append(' ');
        }
        b.append("\n  |\n m|");
        iter = this.getMiddleDescendingIterator();
        while (iter.hasNext()) {
            b.append(iter.next()).append(' ');
        }
        b.append("\n  |\n r|");
        iter = this.getRightDescendingIterator();
        while (iter.hasNext()) {
            b.append(iter.next()).append(' ');
        }
        b.append("\n  |");
        return b.toString();
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.run();
    }
}
