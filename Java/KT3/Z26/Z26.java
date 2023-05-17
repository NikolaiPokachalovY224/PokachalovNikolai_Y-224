public class Z26 {
    public static int LongestPalindrome(String input) {
        int maxLength = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String substring = input.substring(i, j);
                if (isPalindrome(substring) && substring.length() > maxLength) {
                    maxLength = substring.length();
                }
            }
        }
        return maxLength;
    }
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
