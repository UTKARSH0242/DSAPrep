package string;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(chars));
    }

    private static int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;
        int i = 0;

        while (i < n) {
            char ch = chars[i];
            int count = 0;

            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }

            chars[idx++] = ch;

            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[idx++] = c;
                }
            }
        }
        return idx;
    }
}
