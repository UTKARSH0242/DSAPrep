package array.slidingWindowAndTwoPointers;

public class MergeAlternately {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqrst";

        // Test cases
        System.out.println("Result 1: " + mergeAlternately(word1, word2)); // Expected: apbqcrs
        System.out.println("Result 2: " + mergeAlternately("abcd", "b"));     // Expected: ab
        System.out.println("Result 3: " + mergeAlternately("a", "b"));     // Expected: ab
        System.out.println("Result 4: " + mergeAlternately("abcd", ""));   // Expected: abcd
    }

    public static String mergeAlternately(String word1, String word2) {

        StringBuilder merged = new StringBuilder();
        int p1 = 0; // Pointer for word1
        int p2 = 0; // Pointer for word2
        int len1 = word1.length();
        int len2 = word2.length();

        // Alternating merge while both pointers are valid
        while (p1 < len1 && p2 < len2) {
            merged.append(word1.charAt(p1));
            merged.append(word2.charAt(p2));
            p1++;
            p2++;
        }

        // Append remaining characters from word1 (if any)
        if (p1 < len1) {
            merged.append(word1.substring(p1));
        }

        // Append remaining characters from word2 (if any)
        if (p2 < len2) {
            merged.append(word2.substring(p2));
        }

        return merged.toString();
    }
}