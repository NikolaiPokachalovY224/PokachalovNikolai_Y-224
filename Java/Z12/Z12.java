public class Z12 {
    private int start;
    public Z12(int start) {
        this.start = start;
    }
    public void generateSeries(int step, int count) {
        System.out.print("Сгенерированный ряд чисел: ");
        for (int i = 0; i < count; i++) {
            int currentNumber = (start + i * step) * (start + i * step);
            System.out.print(currentNumber + " ");
        }
    }
}
