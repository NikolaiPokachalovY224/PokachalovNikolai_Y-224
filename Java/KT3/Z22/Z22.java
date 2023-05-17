public class Z22 {
    public static double calculateTriangleArea(double sideA, double sideB, double sideC) {
        double s = (sideA + sideB + sideC) / 2;
        double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        return area;
    }
}
