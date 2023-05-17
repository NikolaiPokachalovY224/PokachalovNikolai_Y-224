public class Z28 {
    public int[] findConsecutiveSquares(int n) {
        for (int i = 1; i <= n / 2; i++) {
            int square1 = i * i;
            int square2 = (i + 1) * (i + 1);
            int difference = square2 - square1;
            if (difference == n) {
                return new int[] { square1, square2 };
            }
        }
        return null;
    }
}
