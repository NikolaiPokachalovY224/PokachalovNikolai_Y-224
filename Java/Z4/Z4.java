public class Z4 {
    public static int parseInputAndCountCharacters(String input) {
        input = input.replaceAll("\\s+", "");
        int openingBracketIndex = input.indexOf("(");
        int closingBracketIndex = input.indexOf(")");
        String str = input.substring(openingBracketIndex + 1, closingBracketIndex);
        char character;
        if (input.charAt(closingBracketIndex - 1) == '\'') {
            character = input.charAt(closingBracketIndex - 2);
        } else {
            character = input.charAt(closingBracketIndex - 1);
        }
        int count = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }
}
