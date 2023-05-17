public class Z27 {
    public static String encryptCaesarCipher(String input, int shift, int direction) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char shiftedChar = (char) (c + (shift * direction));
                if ((Character.isUpperCase(c) && shiftedChar > 'Z') || (Character.isLowerCase(c) && shiftedChar > 'z')) {
                    shiftedChar -= 26;
                } else if ((Character.isUpperCase(c) && shiftedChar < 'A') || (Character.isLowerCase(c) && shiftedChar < 'a')) {
                    shiftedChar += 26;
                }
                encryptedText.append(shiftedChar);
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }
}
