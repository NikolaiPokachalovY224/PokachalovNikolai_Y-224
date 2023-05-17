public class Z24 {
    public static int Sum(int M, int N, int[] divisors) {
        int sum = 0;
        for (int i = M; i <= N; i++) {
            for (int divisor : divisors) {
                if (i % divisor == 0) {
                    sum += i;
                    break;
                }
            }
        }
        return sum;
    }
}
