public class Z8 {
    private double a;
    private double b;
    private double c;
    public Z8(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public boolean isTriangle() {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
    public double calculateLargestExternalAngle() {
        double cosA = (b * b + c * c - a * a) / (2 * b * c);
        double angleA = Math.toDegrees(Math.acos(cosA));
        double largestAngle = 180 - angleA;
        return largestAngle;
    }
}
