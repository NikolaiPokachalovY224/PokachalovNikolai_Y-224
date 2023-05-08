class Z11 {
    public String removeVowels(String input) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Проверяем, является ли символ гласным
            if (!isVowel(c)) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        // Проверяем, является ли символ гласным
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'а' || c == 'е' || c == 'ё' || c == 'и' || c == 'о'
                || c == 'у' || c == 'ы' || c == 'э' || c == 'ю' || c == 'я';
    }
}
