import java.util.Scanner;

public class Study01_4 {
    public static void main(String[] args) {

        final String[][] week = { { "sun", "日" }, { "mon", "月" }, { "tue", "火" }, { "wed", "水" }, { "thu", "木" },
                { "fri", "金" }, { "sat", "土" } };

        int weekcount = 0;
        Scanner scanner = new Scanner(System.in);

        top: while (true) {
            System.out.print("調べたい日付を入力してください（ 4 月 3 日 => 4 3 ）: ");

            String input = scanner.next();

            int inputmonth = Integer.parseInt(input);
            input = scanner.next();
            int inputday = Integer.parseInt(input);
            String weekinput = args[0];

            if (0 == inputmonth && 0 == inputday) { // 終了判定
                System.out.println("処理を終了します");
                break top;
            } else {
                for (int w = 0; w <= 6; w++) {

                    if (week[w][0].equals(weekinput)) { // 入力変換
                        weekcount = w;
                    }
                }

                if (checkinputday(inputmonth, inputday)) { // 日付チェック
                    weekcount += searchweek(inputmonth, inputday); // 曜日判定
                    System.out.println(inputmonth + " 月 " + inputday + " 日は " + week[weekcount % 7][1] + " 曜日です"); // %7で正常な範囲に収める
                } else {
                    System.out.println("調べたい日付が不正な組です");
                }

            }
        }
    }

    public static boolean checkinputday(int month, int day) {
        boolean isValidDate = true;

        if (month < 1 || month > 12) {
            isValidDate = false;
        }
        int maxDaysInMonth = 31;

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDaysInMonth = 30;
        } else if (month == 2) {

            if (day < 1 || day > 28) {
                isValidDate = false;
            }
            maxDaysInMonth = 28;
        }

        if (day < 1 || day > maxDaysInMonth) {
            isValidDate = false;
        }

        return isValidDate;

    }

    public static int searchweek(int inputmonth, int inputday) {
        int day = 0;
        int daycount = 0;
        for (int m = 1; m <= 12; m++) {
            switch (m) {
                case 4:
                case 6:
                case 9:
                case 11:
                    day = 30;
                    break;
                case 2:
                    day = 28;
                    break;
                default:
                    day = 31;
                    break;
            }
            for (int d = 1; d <= day; d++) {

                if (m == inputmonth && d == inputday) {
                    return daycount % 7;
                }
                daycount++;
            }
        }
        return 8;
    }
}
