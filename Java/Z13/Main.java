import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите начало ряда: ");
        int start = scanner.nextInt();
        System.out.print("Введите шаг: ");
        int step = scanner.nextInt();
        System.out.print("Введите количество шагов: ");
        int stepsCount = scanner.nextInt();
        Z13 numberSeries = new Z13(start);
        numberSeries.generateSeries(step, stepsCount);
    }
}
