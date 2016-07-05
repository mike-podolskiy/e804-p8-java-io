//CHECKSTYLE:OFF
package kz.mix.e804.io.character;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// C:\Users\Podolskiy.Mikhail\Desktop\FILES\limerick.txt
// Content of the file limerick.txt:
// There was a young lady of Niger
// Who smiled as she rode on a tiger.
// They returned from the ride
// With the lady inside
// And a smile on the face of the tiger.

// read the input file and convert it into "tokens" of words;
// convert the words to same case (lower case), remove duplicates, and print the words
public class Tokenize {
    public static void main(String[] args) {
        // read the input file
        if (args.length != 1) {
            System.err.println("pass the name of the file to be read as an argument");
            System.exit(-1);
        }

        String fileName = args[0];
        // use a TreeSet<String> which will automatically sort the words
        // in alphabetical order
        Set<String> words = new TreeSet<>();
        try (Scanner tokenzingScanner = new Scanner(new FileReader(fileName))) {
            // set the delimiter for text as non-words (special characters,
            // white-spaces, etc), meaning that all words other than punctuation
            // characters, and white-spaces will be returned
            tokenzingScanner.useDelimiter("\\W");

            while (tokenzingScanner.hasNext()) {
                String word = tokenzingScanner.next();
                if (!word.equals("")) { // process only non-empty strings
                    // convert to lowercase and then add to the set
                    words.add(word.toLowerCase());
                }
            }

            // now words are in alphabetical order without duplicates,
            // print the words separating them with tabs
            for (String word : words) {
                System.out.print(word + '\t');
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("Cannot read the input file - pass a valid file name");
        }
    }
}
