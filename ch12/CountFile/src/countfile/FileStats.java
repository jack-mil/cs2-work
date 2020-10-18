package countfile;

/**
 * A simple data class containing statistics about a file. 
 * Used to return a packaged triple of relevant info.
 */
public class FileStats {

    int lines;
    int words;
    int chars;

    /**
     * Create a FileStats object with `lines`, `words`, and `chars` data fields
     */
    FileStats() {
        this.lines = 0;
        this.words = 0;
        this.chars = 0;
    }

    /**
     * Return stats in the form: 
     * " 981 characters
     *   173 words
     *   10 lines "
     */
    @Override
    public String toString() {
        return String.format(
            "%d characters\n" +
            "%d words\n" +
            "%d lines",
            chars, words, lines);
    }
}
