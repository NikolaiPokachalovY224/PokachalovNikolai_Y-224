import java.util.Arrays;
import java.util.Random;
public class Matrix {
    private int[][] matrix;
    public Matrix(int x) {
        matrix = new int[x][x];
        Random rand = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(9) + 1;
            }
        }
    }
    public int sum() {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
    public int diff() {
        int diff = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                diff -= matrix[i][j];
            }
        }
        return diff;
    }
    public int mult() {
        int product = 1;
        for (int i = 0; i < matrix.length; i++) {
            product *= matrix[i][i];
        }
        return product;
    }
    public String toString() {
        return Arrays.deepToString(matrix);
    }
}
