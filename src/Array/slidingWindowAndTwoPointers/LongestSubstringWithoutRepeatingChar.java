package array.slidingWindowAndTwoPointers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; // Import the Scanner class

public class LongestSubstringWithoutRepeatingChar {

    // The core logic (your provided, optimized solution) remains the same
    public static int lengthOfLongestSubstring(String s) {
        // Handle null or empty string case
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // HashMap stores the character and its last seen index
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int n = s.length();
        int left = 0; // The start of the sliding window

        for (int right = 0; right < n; right++) {
            char currChar = s.charAt(right);

            // 1. Check for a repeat character within the current window
            if(map.containsKey(currChar)){
                // If found, move the 'left' pointer to be one position
                // past the previous occurrence of this character.
                // We use Math.max to ensure 'left' only moves forward.
                left = Math.max(left, map.get(currChar) + 1);
            }

            // 2. Update the character's last seen index
            map.put(currChar, right);

            // 3. Update the maximum length found so far (current window size is right - left + 1)
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Longest Substring Without Repeating Characters ---");
        System.out.print("Enter the string: ");

        // Read the entire line of input
        String inputString = scanner.nextLine();

        // Close the scanner
        scanner.close();

        // Check if the input is valid before processing
        if (inputString.isEmpty()) {
            System.out.println("The string is empty. Length: 0");
        } else {
            // Call the optimized method
            int length = lengthOfLongestSubstring(inputString);

            // Output the result
            System.out.println("\nInput String: \"" + inputString + "\"");
            System.out.println("Length of the longest substring without repeating characters: **" + length + "**");
        }
    }
}