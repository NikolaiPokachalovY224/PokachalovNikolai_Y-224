import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int secondNumber = scanner.nextInt();
        int start;
        int step;
        int count;
        if (firstNumber < secondNumber) {
            start = firstNumber;
            step = firstNumber;
            count = secondNumber;
        } else {
            start = secondNumber;
            step = secondNumber;
            count = firstNumber;
        }
        Z12 numberSeries = new Z12(start);
        numberSeries.generateSeries(step, count);
    }
}
