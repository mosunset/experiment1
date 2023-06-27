public class Lesson03_4 {
    public static void main(String[] args) {
        int[][] timeTable = new int[9][9];

        /* -----ここから追加----- */
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                timeTable[y][x] = (x + 1) * (y + 1);
                System.out.printf("%3d",timeTable[y][x]);
            }
            System.out.println();
        }

        /* -----ここまで追加----- */

        // 以下はtimeTableを用いて九九表を作成できているかを
        // 確認するためのものであり、消さないこと
        System.out.println();
        System.out.println("---以下確認用---");
        System.out.println("2 * 4 = " + timeTable[1][3]);
        System.out.println("6 * 8 = " + timeTable[5][7]);
    }

}