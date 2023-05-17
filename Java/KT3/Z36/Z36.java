public class Z36 {
    private int[] secretCode;
    public Z36() {
        secretCode = generateCode();
    }
    private int[] generateCode() {
        int[] code = new int[4];
        for (int i = 0; i < 4; i++) {
            code[i] = (int) (Math.random() * 10);
        }
        return code;
    }
    public int checkGuess(int[] guess) {
        int matches = 0;
        for (int i = 0; i < 4; i++) {
            if (guess[i] == secretCode[i]) {
                matches++;
            }
        }
        return matches;
    }
}
