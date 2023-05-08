import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк матрицы: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов матрицы: ");
        int cols = scanner.nextInt();
        int[][] matrix = Z1.generateRandomMatrix(rows, cols);
        System.out.println("Исходная матрица:");
        Z1.printMatrix(matrix);
        int[][] transposedMatrix = Z1.transposeMatrix(matrix);
        System.out.println("Транспонированная матрица:");
        Z1.printMatrix(transposedMatrix);
    }
}
