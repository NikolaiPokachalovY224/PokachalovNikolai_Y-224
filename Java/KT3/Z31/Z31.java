import java.util.*;
public class Z31 {
    public long calculateFibonacci(int f) {
        if (f <= 2) {
            return 1;
        }
        long fibMinus2 = 1;
        long fibMinus1 = 1;
        long fibonacciNumber = 0;
        for (int i = 3; i <= f; i++) {
            fibonacciNumber = fibMinus2 + fibMinus1;
            fibMinus2 = fibMinus1;
            fibMinus1 = fibonacciNumber;
        }
        return fibonacciNumber;
    }
    public Map<Integer, Integer> findDigitOccurrences(long number) {
        Map<Integer, Integer> digitOccurrences = new HashMap<>();
        while (number != 0) {
            int digit = (int) (number % 10);
            digitOccurrences.put(digit, digitOccurrences.getOrDefault(digit, 0) + 1);
            number /= 10;
        }
        return digitOccurrences;
    }
    public List<Map.Entry<Integer, Integer>> findMaxOccurrences(int f) {
        long fibonacciNumber = calculateFibonacci(f);
        Map<Integer, Integer> digitOccurrences = findDigitOccurrences(fibonacciNumber);
        List<Map.Entry<Integer, Integer>> maxOccurrences = new ArrayList<>();
        int maxOccurrence = 0;
        for (Map.Entry<Integer, Integer> entry : digitOccurrences.entrySet()) {
            int digit = entry.getKey();
            int occurrence = entry.getValue();
            if (occurrence > maxOccurrence) {
                maxOccurrence = occurrence;
                maxOccurrences.clear();
                maxOccurrences.add(entry);
            } else if (occurrence == maxOccurrence) {
                maxOccurrences.add(entry);
            }
        }
        return maxOccurrences;
    }
}
