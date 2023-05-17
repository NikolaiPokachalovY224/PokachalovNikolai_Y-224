import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение f: ");
        int f = scanner.nextInt();
        Z31 z31 = new Z31();
        List<Map.Entry<Integer, Integer>> maxOccurrences = z31.findMaxOccurrences(f);
        for (Map.Entry<Integer, Integer> entry : maxOccurrences) {
            System.out.print("(" + entry.getValue() + ", " + entry.getKey() + ") ");
        }
        System.out.println();
        scanner.close();
    }
}
