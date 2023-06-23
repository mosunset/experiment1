public class Lesson20_3 {
    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        int num = max;
        pascal(num, max);
    }

    // 再帰呼び出しを用いて表示するパスカルの三角形の数値の計算を行う
    static int[] pascal(int num, int max) {
        // -----add here-----
        int[] row = new int[num + 1]; // 最初の場合その入力で最大の行の配列

        if (num == 0) {
            // 三角形の先頭行の場合、要素は必ず1
            row[0] = 1;
        } else {
            // 三角形の先頭行以外の場合、前の行の要素を参照して計算
            int[] prevRow = pascal(num - 1, max);
            row[0] = 1; // 先頭要素は必ず1
            row[num] = 1; // 末尾要素も必ず1

            // 中間の要素を計算
            for (int i = 1; i < num; i++) {
                row[i] = prevRow[i - 1] + prevRow[i];
            }
        }

        if (num == max) {
            // 最終行の場合、計算結果を返す
            return row;
        } else {
            // 途中の行の場合、計算結果を表示して返す
            print(row, max);
            return row;
        }

    }

    // 配列を受け取り表示する
    static void print(int[] array, int max) {
        // -----add here-----
        for (int x = max - array.length + 1; x > 1; x--) { // 成形用
            System.out.printf("  ");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%3d ", array[i]);
        }
        System.out.println();
    }
}
