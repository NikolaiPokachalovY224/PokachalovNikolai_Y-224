import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите начальное число M: ");
        int M = scanner.nextInt();
        System.out.print("Введите конечное число N: ");
        int N = scanner.nextInt();
        System.out.print("Введите количество делителей: ");
        int numDivisors = scanner.nextInt();
        int[] divisors = new int[numDivisors];
        System.out.println("Введите делители:");
        for (int i = 0; i < numDivisors; i++) {
            divisors[i] = scanner.nextInt();
        }
        int sum = Z25.Sum(M, N, divisors);
        System.out.println("Сумма чисел, делящихся на все делители без остатка: " + sum);
        scanner.close();
    }
}
