package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        //throw new UnsupportedOperationException("You should implement this method.");
        List<String> result = new ArrayList<>();
        String toAdd = "";

        for (int i = 0; i < source.length(); i++) {
            boolean equalsDelimiter = false;
            String charToAdd = Character.toString(source.charAt(i));
            for (String s : delimiters) {
                if (charToAdd.equals(s)) {
                    equalsDelimiter = true;
                }
            }
            if (equalsDelimiter) {
                result.add(toAdd);
                toAdd = "";
            } else {
                toAdd += charToAdd;
            }
        }
        result.add(toAdd);
        result.removeIf(String::isEmpty);
        return result;
    }
}