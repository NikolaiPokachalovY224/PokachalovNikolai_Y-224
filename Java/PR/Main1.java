import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        Matrix matrix = new Matrix(n);
        matrix.fillRandom();
        matrix.print();
        System.out.println("Сумма чисел выше главной диагонали: " + matrix.sumAbove());
        System.out.println("Разница чисел ниже главной диагонали: " + matrix.diffBelow());
        System.out.println("Произведение чисел на главной диагонали: " + matrix.multDiagonal());
    }
}

class Matrix {
    private int[][] data;
    private int size;

    public Matrix(int size) {
        this.size = size;
        data = new int[size][size];
    }

    public void fillRandom() {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = rand.nextInt(10);
            }
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int sumAbove() {
        int sumAbove = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i < j) {
                    sumAbove += data[i][j];
                }
            }
        }
        return sumAbove;
    }

    public int diffBelow() {
        int diffBelow = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i > j) {
                    diffBelow -= data[i][j];
                }
            }
        }
        return diffBelow;
    }

    public int multDiagonal() {
        int multDiagonal = 1;
        for (int i = 0; i < size; i++) {
            multDiagonal *= data[i][i];
        }
        return multDiagonal;
    }
}
