import java.util.ArrayList;
import java.util.List;

public class DateMarkingExample {
    public static void main(String[] args) {
        String[][] twoDimensionalArray = {
                {"2023-11-27", "2023-11-28", "2023-11-29", "2023-11-30", "2023-12-01", "2023-12-02", "2023-12-03"},
                {"2023-12-04", "2023-12-05", "2023-12-06", "2023-12-07", "2023-12-08", "2023-12-09", "2023-12-10"},
                {"2023-12-11", "2023-12-12", "2023-12-13", "2023-12-14", "2023-12-15", "2023-12-16", "2023-12-17"},
                {"2023-12-18", "2023-12-19", "2023-12-20", "2023-12-21", "2023-12-22", "2023-12-23", "2023-12-24"},
                {"2023-12-25", "2023-12-26", "2023-12-27", "2023-12-28", "2023-12-29", "2023-12-30", "2023-12-31"}
        };

        String[] oneDimensionalArray = {
                "2023-12-01", "2023-12-02", "2023-12-03",
                "2023-12-04", "2023-12-05", "2023-12-06", "2023-12-07", "2023-12-08", "2023-12-09", "2023-12-10",
                "2023-12-11", "2023-12-12", "2023-12-13", "2023-12-14", "2023-12-17",
                "2023-12-18", "2023-12-19", "2023-12-21", "2023-12-22", "2023-12-23", "2023-12-24",
                "2023-12-25", "2023-12-26", "2023-12-27", "2023-12-28", "2023-12-29", "2023-12-30", "2023-12-31"
        };

        List<DateInfo> result = markConsecutiveDates(twoDimensionalArray, oneDimensionalArray);

        // 打印标记结果
        for (DateInfo dateInfo : result) {
            System.out.println("日期：" + dateInfo.getDate() + "，左侧是否连续：" + dateInfo.isLeft() + "，右侧是否连续：" + dateInfo.isRight());
        }
    }

    static class DateInfo {
        private final String date;
        private final boolean left;
        private final boolean right;

        public DateInfo(String date, boolean left, boolean right) {
            this.date = date;
            this.left = left;
            this.right = right;
        }

        public String getDate() {
            return date;
        }

        public boolean isLeft() {
            return left;
        }

        public boolean isRight() {
            return right;
        }
    }

    private static List<DateInfo> markConsecutiveDates(String[][] twoDArray, String[] oneDArray) {
        List<DateInfo> result = new ArrayList<>();

        for (String date : oneDArray) {
            boolean isConsecutive = false;
            boolean left = false;
            boolean right = false;
            int rowIndex = -1;
            int dateIndex = -1;

            // Find the row index containing the date
            for (int i = 0; i < twoDArray.length; i++) {
                if (twoDArray[i].length > 0) {
                    dateIndex = indexOf(twoDArray[i], date);
                    if (dateIndex != -1) {
                        rowIndex = i;
                        break;
                    }
                }
            }

            if (rowIndex != -1) {
                String[] row = twoDArray[rowIndex];

                // Check consecutive dates
                if (dateIndex > 0 && dateIndex < row.length - 1) {
                    int prevDateIndex = indexOf(oneDArray, row[dateIndex - 1]);
                    int nextDateIndex = indexOf(oneDArray, row[dateIndex + 1]);
                    isConsecutive = prevDateIndex != -1 || nextDateIndex != -1;

                    left = isConsecutive && prevDateIndex == -1;
                    right = isConsecutive && nextDateIndex == -1;
                } else if (dateIndex == 0) {
                    right = true;
                } else if (dateIndex == row.length - 1) {
                    left = true;
                }
            }

            // If the date is not consecutive, set both left and right to true
            if (!isConsecutive) {
                left = true;
                right = true;
            }

            result.add(new DateInfo(date, left, right));
        }

        return result;
    }

    private static int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
}
