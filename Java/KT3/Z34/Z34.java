import java.util.*;
public class Z34 {
    public static void sortNumbersByDigitSum(List<Integer> numbers) {
        numbers.sort(Comparator.comparingInt(Z34::getDigitSum));
    }
    private static int getDigitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
