class Z40 {
    public static String rangeExtraction(int[] arr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int rangeStart = i;
            while (i + 1 < arr.length && arr[i + 1] - arr[i] == 1) {
                i++;
            }
            int rangeEnd = i;
            if (rangeEnd - rangeStart >= 2) {
                result.append(arr[rangeStart]).append("-").append(arr[rangeEnd]).append(",");
            } else {
                for (int j = rangeStart; j <= rangeEnd; j++) {
                    result.append(arr[j]).append(",");
                }
            }
        }
        return result.substring(0, result.length() - 1);
    }
}
