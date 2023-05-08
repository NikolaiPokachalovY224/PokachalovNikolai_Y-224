public class Z7 {
    public double findNearestSquare(double number) {
        double closestSquare = 0;
        double closestDistance = Double.MAX_VALUE;
        for (double i = 0; i <= number; i++) {
            double square = i * i;
            double distance = Math.abs(square - number);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestSquare = square;
            }
        }
        return closestSquare;
    }
}
