package string;

public class RepeatedSubStringPattern {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }

    private static boolean repeatedSubstringPattern(String s) {

        int n = s.length();
        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0){
                String sub = s.substring(0, len);
                StringBuilder sb = new StringBuilder();
                int repCount = n / len;


                sb.append(sub.repeat(repCount));

                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }
}
