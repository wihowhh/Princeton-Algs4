/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

/*
 Using algs4.jar
 reads a sequence of words from standard input and prints one of those words uniformly at random.
 Do not store the words in an array or list.
 Instead, use Knuth’s method: when reading the ith word, select it with probability 1/i to be the champion, replacing the previous champion.
 After reading all of the words, print the surviving champion.
 */

/*
 the following library functions may be useful:
StdIn.readString(): reads and returns the next string from standard input.
StdIn.isEmpty(): returns true if there are no more strings available on standard input, and false otherwise.
StdOut.println(): prints a string and terminating newline to standard output. It’s also fine to use System.out.println() instead.
StdRandom.bernoulli(p): returns true with probability p and false with probability 1−p.
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champion = null;
        int count = 0;
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / ++count)) {
                champion = word;
            }
        }
        StdOut.println(champion);
    }
}
