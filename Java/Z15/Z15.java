class Z15 {
    public static String removeDuplicateWords(String input) {
        String[] words = input.split("\\s+");
        String[] uniqueWords = new String[words.length];
        int count = 0;
        for (String word : words) {
            boolean isDuplicate = false;
            for (int i = 0; i < count; i++) {
                if (word.equals(uniqueWords[i])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueWords[count++] = word;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(uniqueWords[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
