import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int sumAbove = 0;
        int diffBelow = 0;
        int multDiagonal = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    sumAbove += matrix[i][j];
                } else if (i > j) {
                    diffBelow -= matrix[i][j];
                } else {
                    multDiagonal *= matrix[i][j];
                }
            }
        }
        System.out.println("Сумма чисел выше главной диагонали: " + sumAbove);
        System.out.println("Разница чисел ниже главной диагонали: " + diffBelow);
        System.out.println("Произведение чисел на главной диагонали: " + multDiagonal);
    }
}
