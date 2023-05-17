public class Z23 {
    public static int Sum(int N, int divisor1, int divisor2) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (i % divisor1 == 0 || i % divisor2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
