public class Z14 {
    private Integer[] numbers = new Integer[3];
    public void storeNumber(int number) {
        int emptyIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == null) {
                emptyIndex = i;
                break;
            }
        }
        if (emptyIndex != -1) {
            numbers[emptyIndex] = number;
        } else {
            int minIndex = 0;
            int minValue = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] < minValue) {
                    minIndex = i;
                    minValue = numbers[i];
                }
            }
            if (number > minValue) {
                numbers[minIndex] = number;
            }
        }
        System.out.println("Текущее состояние ячеек памяти: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Ячейка " + (i + 1) + ": " + numbers[i]);
        }
    }
}
