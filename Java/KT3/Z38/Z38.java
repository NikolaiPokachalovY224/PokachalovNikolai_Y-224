public class Z38 {
    public String modifyText(String inputText) {
        StringBuilder modifiedText = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            char currentChar = inputText.charAt(i);
            if (Character.isLetter(currentChar)) {
                currentWord.append(currentChar);
            } else {
                if (currentWord.length() > 0) {
                    char firstLetter = currentWord.charAt(0);
                    String restOfWord = currentWord.substring(1);
                    String modifiedWord = restOfWord + firstLetter + "ауч";
                    modifiedText.append(modifiedWord);
                    currentWord.setLength(0);
                }
                modifiedText.append(currentChar);
            }
        }
        if (currentWord.length() > 0) {
            char firstLetter = currentWord.charAt(0);
            String restOfWord = currentWord.substring(1);
            String modifiedWord = restOfWord + firstLetter + "ауч";
            modifiedText.append(modifiedWord);
        }
        return modifiedText.toString();
    }
}
