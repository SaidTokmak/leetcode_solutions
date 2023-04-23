package LongestPalindrome;

public class Solution {
    public static String longestPalindrome(String s) {
        String result = String.valueOf(s.charAt(0));
        int mostSize = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length - 1; i++) {

            if (charArray[i] == charArray[i+1]) {
                String palindrome = findPalindrome(s, charArray, i, i+1, mostSize);
                result = palindrome != null ? palindrome : result;
                mostSize = result.length();
            }

            if (i+2 <= charArray.length - 1 && charArray[i] == charArray[i+2]) {
                String palindrome = findPalindrome(s, charArray, i, i+2, mostSize);
                result = palindrome != null ? palindrome : result;
                mostSize = result.length();
            }
        }
        return result;
    }

    private static String findPalindrome(String s, char[] charArray, int negativeLocation, int positiveLocation, int mostSize) {
        while (negativeLocation >= 0 && positiveLocation < charArray.length) {
            if (charArray[negativeLocation] != charArray[positiveLocation]) {
                break;
            }
            negativeLocation--;
            positiveLocation++;
        }

        if (mostSize < positiveLocation - negativeLocation) {
            return s.substring(negativeLocation + 1, positiveLocation);
        }

        return null;
    }
}
