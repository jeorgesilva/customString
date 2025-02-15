package customstring;

/**
 * This class represents a more customizable version of a String,
 * with additional attributes and methods.
 */
public class CustomString {

    // Instance variables
    private String myString;
    private boolean isSet;

    // Constructor
    public CustomString() {
        this.myString = null;
        this.isSet = false;
    }

    // Methods

    /**
     * Returns the current string.
     * If the current string is null or has not been set, it returns null.
     *
     * @return current string
     */
    public String getString() {
        if (isSet && myString != null) {
            return myString;
        }
        return null;
    }

    /**
     * Sets the value of the current string and updates isSet.
     * If the given string is null, sets isSet to false.
     *
     * @param string value to be set
     */
    public void setString(String string) {
        if (string == null) {
            this.myString = null;
            this.isSet = false;
        } else {
            this.myString = string;
            this.isSet = true;
        }
    }

    /**
     * Returns a new string where the specified alphabetical characters are removed.
     * The removal is case insensitive.
     *
     * @param arg characters to be removed
     * @return new string with characters removed
     */
    public String remove(String arg) {
        if (myString == null || myString.isEmpty() || !isSet) {
            return "";
        }

        String argLower = arg.toLowerCase();
        StringBuilder result = new StringBuilder();

        for (char c : myString.toCharArray()) {
            if (Character.isLetter(c) && argLower.contains(String.valueOf(Character.toLowerCase(c)))) {
                continue; // Skip the character
            } else {
                result.append(c); // Keep the character
            }
        }

        return result.toString();
    }

    /**
     * Returns a new string where the capitalization of specified characters is reversed.
     * The reversal is case insensitive.
     *
     * @param arg characters to have their capitalization reversed
     * @return new string with reversed capitalization
     */
    public String reverse(String arg) {
        if (myString == null || myString.isEmpty() || !isSet) {
            return "";
        }

        String argLower = arg.toLowerCase();
        StringBuilder result = new StringBuilder();

        for (char c : myString.toCharArray()) {
            if (Character.isLetter(c) && argLower.contains(String.valueOf(Character.toLowerCase(c)))) {
                // Reverse capitalization
                if (Character.isUpperCase(c)) {
                    result.append(Character.toLowerCase(c));
                } else {
                    result.append(Character.toUpperCase(c));
                }
            } else {
                result.append(c); // Keep the character as is
            }
        }

        return result.toString();
    }

    /**
     * Returns a new string where letters either >= or <= the given character are removed.
     * The comparison is case insensitive.
     *
     * @param n    character to compare to
     * @param more if true, removes letters >= n; if false, removes letters <= n
     * @return new string with letters removed
     */
    public String filterLetters(char n, boolean more) {
        if (myString == null) {
            return "";
        }

        if (!Character.isLetter(n)) {
            return "";
        }

        char nLower = Character.toLowerCase(n);
        StringBuilder result = new StringBuilder();

        for (char c : myString.toCharArray()) {
            if (Character.isLetter(c)) {
                char cLower = Character.toLowerCase(c);
                if (more) {
                    if (cLower < nLower) {
                        result.append(c); // Keep the character
                    }
                } else {
                    if (cLower > nLower) {
                        result.append(c); // Keep the character
                    }
                }
            } else {
                result.append(c); // Keep non-letter characters
            }
        }

        return result.toString();
    }
}
