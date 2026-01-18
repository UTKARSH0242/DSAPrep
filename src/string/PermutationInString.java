package string;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    private static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int [] s1Freq = new int[26];
        int [] windowFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s1Freq, windowFreq)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }
        return false;
    }
}
