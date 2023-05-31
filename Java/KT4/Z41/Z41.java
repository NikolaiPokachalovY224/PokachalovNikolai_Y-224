class Z41 {
    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "сейчас";
        }
        int[] units = {31536000, 86400, 3600, 60, 1};
        String[][] unitNames = {{"год", "года", "лет"}, {"день", "дня", "дней"}, {"час", "часа", "часов"}, {"минута", "минуты", "минут"}, {"секунда", "секунды", "секунд"}};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < units.length; i++) {
            int value = seconds / units[i];
            if (value > 0) {
                result.append(value).append(" ");
                if (value % 10 == 1 && value % 100 != 11) {
                    result.append(unitNames[i][0]);
                } else if (value % 10 >= 2 && value % 10 <= 4 && (value % 100 < 10 || value % 100 >= 20)) {
                    result.append(unitNames[i][1]);
                } else {
                    result.append(unitNames[i][2]);
                }
                result.append(", ");
                seconds -= value * units[i];
            }
        }
        String res = result.substring(0, result.length() - 2);
        int lastCommaIndex = res.lastIndexOf(",");
        if (lastCommaIndex != -1) {
            res = res.substring(0, lastCommaIndex) + " и" + res.substring(lastCommaIndex + 1);
        }
        return res;
    }
}
