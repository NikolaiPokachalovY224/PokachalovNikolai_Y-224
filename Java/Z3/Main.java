import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double[][] triangle = readTriangleFromInput();
        double[] barycenter = Z3.calculateBarycenter(triangle);
        System.out.printf("{%.4f, %.4f}%n", barycenter[0], barycenter[1]);
    }
    public static double[][] readTriangleFromInput() {
        Scanner scanner = new Scanner(System.in);
        double[][] triangle = new double[3][2];
        System.out.println("Введите координаты треугольника:");
        for (int i = 0; i < 3; i++) {
            System.out.printf("Введите координаты вершины %d (x, y): ", i + 1);
            triangle[i][0] = scanner.nextDouble();
            triangle[i][1] = scanner.nextDouble();
        }
        return triangle;
    }
}
