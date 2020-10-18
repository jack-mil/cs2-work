// Jackson Miller
// COSC2103 Computer Science 2
// 2020-10-17
// Exercise 12.13: Count lines, words, and characters in a file
package countfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CountFile {

    /**
     * 
     * @param args Files or folders which contain files to analyze
     */
    public static void main(String[] args) {

        ArrayList<File> filesToProcess = new ArrayList<>();

        /*
         * Create a list of files to process This way we can pass in a paths
         * directories, files, or a combination of both Example: `java
         * countfile.CountFile texts/ foo.txt bar/baz.txt Will grab all files in
         * directory "texts/" and two other files
         */
        for (String arg : args) {
            File file = new File(arg);
            if (file.isDirectory()) {
                filesToProcess.addAll(Arrays.asList(file.listFiles()));
            } else {
                filesToProcess.add(file);
            }
        }   

        // Find counts and print a summary of each file
        for (File file : filesToProcess) {
            try (Scanner reader = new Scanner(file)) {

                FileStats counts = count(reader);
                System.out.printf("File \"%s\" has:\n", file.getPath());
                System.out.println(counts.toString());
                System.out.println();

            } catch (FileNotFoundException e) {
                // Print and error message and continue to next file
                System.out.println("File " + file.getPath() + " does not exist");
            }
        }
    }

    /**
     * 
     * @param reader A scanner object of the text to count
     * @return A StringStat object containing the line, word and character count
     */
    public static FileStats count(Scanner reader) {

        FileStats stats = new FileStats();

        while (reader.hasNextLine()) {
            String line = reader.nextLine();

            // Accumulate lines
            stats.lines++;

            // Accumulate chars
            stats.chars += line.length();

            // Tokenize (on whitespace) the line and accumulate words
            stats.words += new StringTokenizer(line).countTokens();
        }

        return stats;
    }

}
