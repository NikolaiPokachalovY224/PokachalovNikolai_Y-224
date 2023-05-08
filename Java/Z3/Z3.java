public class Z3 {
    public static double[] calculateBarycenter(double[][] triangle) {
        double[] barycenter = new double[2];
        double xSum = 0;
        double ySum = 0;
        for (int i = 0; i < 3; i++) {
            xSum += triangle[i][0];
            ySum += triangle[i][1];
        }
        barycenter[0] = xSum / 3;
        barycenter[1] = ySum / 3;
        return barycenter;
    }
}
