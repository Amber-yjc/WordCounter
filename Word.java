package q1;

/**
 * <p>
 * Word: A class with String for the word and an int representing its frequency.
 * </p>
 *
 * @author Amber(Ying-Ju) Chen
 * @version 2017
 */
public class Word implements Comparable<Word> {
    /**
     * A String for the word.
     */
    private final String word;
    /**
     * The frequency of word.
     */
    private int wordFrequency;

    /**
     * 
     * Constructs an object of type Word.
     * 
     * @param word
     *            the word
     */
    public Word(String word) {
        wordFrequency = 1;
        this.word = word;
    }

    /**
     * Returns the word for this Word.
     * 
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the wordFrequency for this Word.
     * 
     * @return the wordFrequency
     */
    public int getWordFrequency() {
        return wordFrequency;
    }

    /**
     * Increase the count of frequency.
     */
    public void increaseCount() {
        wordFrequency++;
    }

    /*
     * @see java.lang.Object#toString()
     * 
     * @return
     */
    @Override
    public String toString() {
        return "Word [word=" + word + ", wordFrequency=" + wordFrequency + "]";
    }

    /*
     * @Override public int compareTo(Word word, Word word2) { int result = 0; 
     * if
     * (word2.getWordFrequency() > word.getWordFrequency()) { result =
     * word2.getWord().compareTo(word.getWord()); } else { result =
     * word.getWord().compareTo(word2.getWord()); } return result; }
     */

    @Override
    public int compareTo(Word x) {

        if (this.wordFrequency > x.getWordFrequency()) {
            return -1;
        } else if (this.wordFrequency < x.getWordFrequency()) {
            return 1;
        } else {
            return 0;
        }
    }

}
