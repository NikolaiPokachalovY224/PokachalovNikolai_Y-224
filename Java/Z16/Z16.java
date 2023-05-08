public class Z16 {
    public String transformString(String input) {
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowercaseCount++;
            }
        }
        if (uppercaseCount > lowercaseCount) {
            return input.toUpperCase();
        } else if (lowercaseCount > uppercaseCount || (lowercaseCount == uppercaseCount)) {
            return input.toLowerCase();
        } else {
            return input.toUpperCase();
        }
    }
}
