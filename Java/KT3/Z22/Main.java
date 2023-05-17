import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сторону A: ");
        double sideA = scanner.nextDouble();
        System.out.print("Введите сторону B: ");
        double sideB = scanner.nextDouble();
        System.out.print("Введите сторону C: ");
        double sideC = scanner.nextDouble();
        double area = Z22.calculateTriangleArea(sideA, sideB, sideC);
        System.out.println("Площадь треугольника: " + area);
        scanner.close();
    }
}
