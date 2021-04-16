package hw6;

import java.util.HashMap;

public class Formatting {
    private final String text;
    private int numberOfSigns;
    private int numberOfNumbers;
    private int numberOfSpaces;
    private int numberOfLetters;

    public Formatting(String text) {
        this.text = text;
    }

    public void formatText(String text) {
        String removePunctuation = getRemovePunctuation(text);

        String removeNumbers = getString(removePunctuation);

        String removeSpaces = getRemoveSpaces(removeNumbers);

        numberOfLetters = removeSpaces.length();

        HashMap<Character, Integer> chars = new HashMap<>();
        String allLetters = removeSpaces.toLowerCase();
        int counter;
        for (int i = 0; i < allLetters.length(); i++) {
            counter = 0;
            for (int j = 0; j < allLetters.length(); j++) {
                if (allLetters.charAt(i) == allLetters.charAt(j)) {
                    counter++;
                }
                chars.put(allLetters.charAt(i), counter);
            }
        }
        System.out.println("Number of letter: " + numberOfLetters);
        System.out.println("Number of numbers: " + numberOfNumbers);
        System.out.println("Number of punctuation marks: " + numberOfSigns);
        System.out.println("Number of spaces: " + numberOfSpaces);
    }

    private String getRemovePunctuation(String text) {
        String removePunctuation = text.replaceAll("\\p{Punct}", "");
        numberOfSigns = text.length() - removePunctuation.length();
        return removePunctuation;
    }

    public String getRemoveSpaces(String removeNumbers) {
        String removeSpaces = removeNumbers.replaceAll(" ", "");
        numberOfSpaces = removeNumbers.length() - removeSpaces.length();
        return removeSpaces;
    }

    public String getString(String removePunctuation) {
        String removeNumbers = removePunctuation.replaceAll("[0-9]", "");
        numberOfNumbers = removePunctuation.length() - removeNumbers.length();
        return removeNumbers;
    }
}
