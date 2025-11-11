package array.slidingWindowAndTwoPointers;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctChar {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // HashMap to store the frequency of each character in the current window
        Map<Character, Integer> charFrequency = new HashMap<>();
        int left = 0; // The start of the sliding window
        int maxLength = 0; // The result: maximum length of the substring

        // The right pointer expands the window to the right
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charFrequency.put(currentChar, charFrequency.getOrDefault(currentChar, 0) + 1);

            // If the window has more than 'k' distinct characters, shrink it from the left
            while (charFrequency.size() > k) {
                char leftChar = s.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);

                // If the count of the character at the 'left' pointer becomes 0, remove it from the map
                if (charFrequency.get(leftChar) == 0) {
                    charFrequency.remove(leftChar);
                }

                left++; // Move the left pointer to the right to shrink the window
            }

            // Update the maximum length found so far (current window size is right - left + 1)
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
