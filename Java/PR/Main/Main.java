import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите размерность матрицы: ");
        int size = input.nextInt();
        int[][] matrix = createMatrix(size);
        printMatrix(matrix);
        performOperations(matrix);
    }
    public static int[][] createMatrix(int size) {
        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10) + 1;
            }
        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static void performOperations(int[][] matrix) {
        int sum = 0;
        int difference = 0;
        int mult = 1;
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix.length; j++) {
                if (i < j) {
                    sum += matrix[i][j];

                } else if (i > j) {
                    difference -= matrix[i][j];

                } else {
                    mult *= matrix[i][j];
                }
            }
        }
        System.out.println("Сумма:" + sum);
        System.out.println("Произведение:" + mult);
        System.out.println("Разность:" + difference);
    }
}
