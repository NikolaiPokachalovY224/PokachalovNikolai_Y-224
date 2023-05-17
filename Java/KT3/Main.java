import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число N: ");
        int N = scanner.nextInt();
        System.out.print("Введите первый делитель: ");
        int divisor1 = scanner.nextInt();
        System.out.print("Введите второй делитель: ");
        int divisor2 = scanner.nextInt();
        int sum = Z23.Sum(N, divisor1, divisor2);
        System.out.println("Сумма чисел, делящихся на один из делителей без остатка: " + sum);
        scanner.close();
    }
}
