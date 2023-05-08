public class Z13 {
    private int start;
    public Z13(int start) {
        this.start = start;
    }
    public void generateSeries(int step, int stepsCount) {
        System.out.print("Ряд чисел: ");
        for (int i = 0; i < stepsCount; i++) {
            int currentNumber = start + i * step;
            System.out.print(currentNumber + " ");
        }
    }
}
