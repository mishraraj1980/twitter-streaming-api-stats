/*
 * Utilty functions to check whether no of words in the sentence are even or
 * odd, calculate percentage and print console log.
 *
 */
package twitter.stream.util;

/**
 *
 * @author Rajneesh Mishra
 */
public class CommonUtils {

    /**
     * This method is to check whether no of words in the sentence are even or
     * odd.
     *
     * @param str This parameter is the actual sentence.
     * @return boolean Returns True if the no of words are odd otherwise False.
     */
    public static boolean containsOddWords(String str) {
        int count = 0;
        String[] words = str.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            count++;
        }
        if (count % 2 == 1) {
            return true;
        }
        return false;
    }

    /**
     * This method is to calculate percentage
     *
     * @param calculatedNum This parameter contains the calculated number.
     * @param totalNum This parameter contains the total number.
     * @return boolean Returns True if the no of words are odd otherwise False.
     */
    public static float calculatePercentage(float calculatedNum, float totalNum) {
        float percentage = (calculatedNum / totalNum) * 100;
        return percentage;
    }

    /**
     * This method is to print console log.
     *
     * @param key This parameter contains label.
     * @param message This parameter contains the message to be displayed on
     * screen.
     * @return Nothing.
     */
    public static void log(String key, String message) {
        System.out.println(key + " -> " + message);

    }
}
