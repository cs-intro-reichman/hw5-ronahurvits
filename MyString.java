/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        System.out.println(subsetOf("c", "space"));
        System.out.println(subsetOf("cc", "space"));
        System.out.println(subsetOf("sap", "space"));
        System.out.println(spacedString("Caroline"));
        System.out.println(randomStringOfLetters(3));
        System.out.println(remove("meet", "committee"));
        System.out.println(remove("c", "car"));
        System.out.println(remove("line", "caroline"));

    }

    /**
     * * Returns the number of times the given character appears in the given
     * string. * Example: countChar("Center",'e') returns 2 and
     * countChar("Center",'c') returns 0. *
     * 
     * @param str - a string
     * @param c   - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ch) {
                counter++;
            }

        }
        return counter;
    }

    /**
     * Returns true if str1 is a subset string str2, false otherwise
     * Examples:
     * subsetOf("sap","space") returns true
     * subsetOf("spa","space") returns true
     * subsetOf("pass","space") returns false
     * subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (countChar(str2, str1.charAt(i)) < countChar(str1, str1.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character.
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String spaceS = "";
        if (str.length() <= 1) {
            return str;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            spaceS += str.charAt(i) + " ";
        }
        spaceS += str.charAt(str.length() - 1);
        return spaceS;
    }

    /**
     * Returns a string of n lowercase letters, selected randomly from
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String newStr = "";
        for (int i = 0; i < n; i++) {
            int randNum = (int) ((Math.random() * 25) + 97);
            newStr += (char) randNum;
        }

        return newStr;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in
     * the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit"
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String newStr = "";
        for (int i = 0; i < str1.length(); i++) {
            if (countChar(str2, str1.charAt(i))
                    + (countChar(newStr, str1.charAt(i))) != (countChar(str1, str1.charAt(i)))) {
                newStr += str1.charAt(i);
            }

        }

        return newStr;
    }

    /**
     * Returns a string consisting of the given string, with the given
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or
     * "cast", or "cats".
     * 
     * @param ch  - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
        int randomIndex = (int) (Math.random() * (str.length() + 1));
        String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
        return result;
    }
}