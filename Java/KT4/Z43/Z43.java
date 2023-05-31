import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество рядов пирамиды: ");
        int rows = scanner.nextInt();
        int[][] pyramid = new int[rows][];
        for (int i = 0; i < rows; i++) {
            pyramid[i] = new int[i + 1];
            System.out.println("Введите числа " + (i + 1) + "-го ряда через пробел: ");
            for (int j = 0; j <= i; j++) {
                pyramid[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Максимальная сумма скольжения: " + Z43.maxSlideSum(pyramid));
    }
}
