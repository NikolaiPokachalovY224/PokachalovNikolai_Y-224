class Z42 {
    public static int countIntervals(int[][] intervals) {
        int count = 0;
        for (int[] interval : intervals) {
            count += interval[1] - interval[0];
        }
        return count;
    }
}
