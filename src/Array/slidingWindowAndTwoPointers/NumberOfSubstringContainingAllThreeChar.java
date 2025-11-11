package array.slidingWindowAndTwoPointers;

public class NumberOfSubstringContainingAllThreeChar {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numSubstringsWithAllThree(s));
    }

    public static int numSubstringsWithAllThree(String s) {
        // Variable to store final count
        int count = 0;
        // Length of the input string
        int n = s.length();

        // Outer loop to fix the start of the substring
        for (int i = 0; i < n; i++) {
            // Array to track the count of 'a', 'b', and 'c'
            int[] freq = new int[3];

            // Inner loop to fix the end of the substring
            for (int j = i; j < n; j++) {
                // Update frequency for current character
                freq[s.charAt(j) - 'a']++;

                // Check if all three characters are present
                if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                    // Add valid substring
                    count++;
                }
            }
        }

        return count;

    }
}
