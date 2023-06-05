import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class CircularSuffixArray {

    private String text;
    private int n;
    private int[] index;

    private final static int R = 256;

    private class CircularSuffix implements Comparable<CircularSuffix> {
        int offset;

        CircularSuffix(int n) {
            offset = n;
        }

        public int compareTo(CircularSuffix that) {
            if (that == this) return 0;
            for (int i = 0; i < n; i++) {
                if (this.charAt(i) > that.charAt(i))
                    return 1;
                else if (this.charAt(i) < that.charAt(i))
                    return -1;
            }
            return 0;
        }

        public char charAt(int i) {
            return text.charAt(i + offset);
        }
    }

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) throw new IllegalArgumentException();
        text = s + s; // circular string
        n = s.length();
        index = new int[n];
        CircularSuffix[] suffixes = new CircularSuffix[n];
        for (int i = 0; i < n; i++)
            suffixes[i] = new CircularSuffix(i);
        // sort suffixes
        Arrays.sort(suffixes);
        for (int i = 0; i < n; i++)
            index[i] = suffixes[i].offset;
    }

    // length of s
    public int length() {
        return n;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= n) throw new IllegalArgumentException();
        return index[i];
    }

    // unit testing (required)
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            CircularSuffixArray circularSuffixArray = new CircularSuffixArray(s);
            for (int i = 0; i < circularSuffixArray.length(); i++)
                StdOut.println(circularSuffixArray.index(i));
        }
    }
}
