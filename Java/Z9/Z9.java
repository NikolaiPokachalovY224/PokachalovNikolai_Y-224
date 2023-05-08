public class Z9 {
    public boolean isEnding(String firstString, String secondString) {
        int firstLength = firstString.length();
        int secondLength = secondString.length();
        if (firstLength < secondLength) {
            return false;
        }
        String ending = firstString.substring(firstLength - secondLength);
        return ending.equals(secondString);
    }
}
