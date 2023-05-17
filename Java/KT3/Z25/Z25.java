public class Z25 {
    public static int Sum(int M, int N, int[] divisors) {
        int sum = 0;
        for (int i = M; i <= N; i++) {
            boolean divisibleByAll = true;
            for (int divisor : divisors) {
                if (i % divisor != 0) {
                    divisibleByAll = false;
                    break;
                }
            }
            if (divisibleByAll) {
                sum += i;
            }
        }
        return sum;
    }
}
