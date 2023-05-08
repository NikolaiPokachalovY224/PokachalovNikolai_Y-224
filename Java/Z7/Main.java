import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        double inputNumber = scanner.nextDouble();
        Z7 z7 = new Z7();
        double nearestSquare = z7.findNearestSquare(inputNumber);
        double squareRoot = Math.sqrt(nearestSquare);
        System.out.println(+ nearestSquare);
        System.out.println(+ squareRoot);
    }
}
