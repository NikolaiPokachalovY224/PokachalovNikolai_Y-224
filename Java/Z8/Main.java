import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину первой стороны:");
        double a = scanner.nextDouble();
        System.out.println("Введите длину второй стороны:");
        double b = scanner.nextDouble();
        System.out.println("Введите длину третьей стороны:");
        double c = scanner.nextDouble();
        Z8 triangle = new Z8(a, b, c);
        boolean isTriangle = triangle.isTriangle();
        if (isTriangle) {
            double largestAngle = triangle.calculateLargestExternalAngle();
            System.out.println("Из заданных сторон можно составить треугольник.");
            System.out.println("Наибольший внешний угол треугольника: " + largestAngle + " градусов.");
        } else {
            System.out.println("Из заданных отрезков нельзя составить треугольник.");
        }
    }
}
