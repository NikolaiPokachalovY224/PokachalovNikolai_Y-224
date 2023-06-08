import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер матрицы: ");
        int size = in.nextInt();
        System.out.println("Размер матрицы: " + size);
        Matrix matrix = new Matrix(size);
        System.out.println(matrix);
        System.out.println("Сумма элементов выше главной диагонали: " + matrix.sum());
        System.out.println("Разность элементов ниже главной диагонали: " + matrix.diff());
        System.out.println("Произведение элементов на главной диагонали: " + matrix.mult());
    }
}
