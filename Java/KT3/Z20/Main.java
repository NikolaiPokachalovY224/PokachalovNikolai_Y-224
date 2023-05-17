import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите высоту массива: ");
        int m = scanner.nextInt();
        System.out.print("Введите ширину массива: ");
        int n = scanner.nextInt();
        scanner.close();
        Z20 arrayFiller = new Z20();
        int[][] array = arrayFiller.fillArray(m, n);
        arrayFiller.printArray(array);
        arrayFiller.saveArrayToFile(array, "Output.txt");
    }
}
