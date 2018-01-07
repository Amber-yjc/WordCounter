package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>
 * WordCounter: Count the words within the bible.txt file and add them to an
 * ArrayList of words.
 * </p>
 * <li>Includes a list of words and their frequency</li>
 * 
 * @author Amber (Ying-Ju) Chen
 * @version 1.0
 */
public class WordCounter {
    /**
     * An ArrayList of Word elements.
     */
    private ArrayList<Word> listOfWord;
    /**
     * A scanner scanning the contents of file.
     */
    private Scanner fileScan;

    /**
     * 
     * Constructs an object of type WordCounter.
     */
    public WordCounter() {
        listOfWord = new ArrayList<Word>();
    }

    /**
     * Search through a file to find words to add to ArrayList.
     * 
     * @param fileName
     *            the name of the file
     * @return the size of the ArrayList
     * @throws FileNotFoundException
     *             if file is not found
     */
    public int parseBook(String fileName) throws FileNotFoundException {
        int size;

        fileScan = new Scanner(new File(fileName));
        String wordValue;

        while (fileScan.hasNext()) {
            String word = fileScan.next().toLowerCase();
            wordValue = word;
            boolean addWord = true;
            for (Word words : listOfWord) {
                if (words.getWord().equals(wordValue)) {
                    System.out.println("Running");
                    words.increaseCount();
                    addWord = false;
                }
            }
            if (addWord) {
                Word adding = new Word(wordValue);
                listOfWord.add(adding);
            }

        }

        size = listOfWord.size();
        fileScan.close();
        return size;

    }

    /**
     * Accepts a String as a parameter which represents the name of the file to
     * open.
     * 
     * @param n
     *            the number of Word elements to be listed
     * @throw IllegalArgumentException error 
     * when number is smaller or equal to 0
     */
    public void printTopWords(int n) {
        listOfWord.sort(null);
        for (int i = 0; i < n; i++) {
            System.out.println("Index" + i + ": " + listOfWord.get(i));
        }
        if (n < 0) {
            throw new IllegalArgumentException(
                    "Number must be greater than 0.");
        }
    }

    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     *
     * @param args
     *            command line arguments.
     * @throws FileNotFoundException
     *             when file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        WordCounter wordCounter = new WordCounter();
        System.out.println("The size of Word list: " 
        + wordCounter.parseBook("src/bible.txt"));
        final int printedNum = 10;
        wordCounter.printTopWords(printedNum);

    }

}
