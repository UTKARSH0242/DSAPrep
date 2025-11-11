package array.slidingWindowAndTwoPointers;

public class ValidPalindromeTwo {
    public static void main(String[] args) {
//        String s1 = "abcdcba"; // Should be true (already a palindrome)
//        String s2 = "abca";    // Should be true (delete 'c')
//        String s3 = "abc";     // Should be false
//        String s4 = "deeedcba"; // Should be false
//        String s5 = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucmlmgmqfvnbgtapekouga"; // Long test case: true
        String s6 = "cuurc";

//        System.out.println("Test s1 (\"abcdcba\"): " + validPalindrome(s1));
//        System.out.println("Test s2 (\"abca\"): " + validPalindrome(s2));
//        System.out.println("Test s3 (\"abc\"): " + validPalindrome(s3));
//        System.out.println("Test s4 (\"deeedcba\"): " + validPalindrome(s4));
//        System.out.println("Test s5 (long): " + validPalindrome(s5));
        System.out.println("Test s6 (\"cuurc\"): " + validPalindrome(s6));
    }

    /**
     * Checks if a string can be a palindrome after deleting at most one character.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                // Mismatch found! Use the single allowed deletion.
                // We check two possibilities:

                // 1. Delete the left character (i) OR
                // 2. Delete the right character (j)

                // If either of these resulting substrings is a palindrome, return true.
                return isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1);
            }
            i++;
            j--;
        }

        // If the loop completes, it's either an exact palindrome or an empty/single-char string.
        return true;
    }

    /**
     * Helper function to check if a specific substring (defined by its indices) is a palindrome.
     * Used after a deletion attempt.
     */
    private static boolean isPalindromeRange(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}