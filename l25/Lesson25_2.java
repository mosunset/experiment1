import java.util.Random;
import java.util.Arrays;

public class Lesson25_2 {
    // フィールド
    static int[] ascendingArray;
    static int[] descendingArray;
    static int[] randomArray;
    static Random random;

    // メソッド
    public static void main(String[] args) {
        int arraySize = 15; // 配列のサイズ
        long seed = 20150110; // 乱数の種
        init(arraySize, seed); // 配列を作る
        for (int i = 0; i < 3; i++) { // ソートする配列を決める
            int[] currentArray = null; // ソートする配列
            if (i == 0) {
                currentArray = ascendingArray;
                System.out.println("=== ascending  =============================");
            } else if (i == 1) {
                currentArray = descendingArray;
                System.out.println("=== descending =============================");
            } else if (i == 2) {
                currentArray = randomArray;
                System.out.println("=== random     =============================");
            }
            System.out.println(Arrays.toString(currentArray)); // 配列を表示する

            int[] b_array = currentArray.clone();
            BubbleSort bs = new BubbleSort(b_array); // バブルソート
            System.out.println("- BubbleSort -");
            System.out.println("Check before sort: " + bs.checkSort());
            bs.bubbleSort(); // ソート
            display(b_array); // 表示
            System.out.println("Check after sort: " + bs.checkSort()); // 成功したかを表示

            int[] s_array = currentArray.clone();
            SelectionSort ss = new SelectionSort(s_array); // セレクションソート
            System.out.println("- SelectionSort -");
            System.out.println("Check before sort: " + ss.checkSort());
            ss.selectionSort(); // ソート
            display(s_array); // 表示
            System.out.println("Check after sort: " + ss.checkSort()); // 成功したかを表示

            int[] i_array = currentArray.clone();
            InsertionSort is = new InsertionSort(i_array); // 挿入ソート
            System.out.println("- InsertionSort -");
            System.out.println("Check before sort: " + is.checkSort());
            is.insertionSort(); // ソート
            display(i_array); // 表示
            System.out.println("Check after sort: " + is.checkSort()); // 成功したかを表示

            System.out.println();
        }
    }

    public static void display(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static void init(int arraySize, long seed) {
        ascendingArray = new int[arraySize];
        descendingArray = new int[arraySize];
        randomArray = new int[arraySize];

        random = new Random(seed);
        ascendingArray[0] = 0;
        descendingArray[descendingArray.length - 1] = 0;
        randomArray[0] = random.nextInt(randomArray.length * 3);

        for (int i = 1; i < ascendingArray.length; i++) {
            // 1つ前より0--9大きい数
            ascendingArray[i] = ascendingArray[i - 1] + random.nextInt(10);
            // 1つ後より0--9小さい数
            descendingArray[descendingArray.length - 1 - i] = descendingArray[descendingArray.length - i]
                    + random.nextInt(10);
            // ランダム
            randomArray[i] = random.nextInt(randomArray.length * 3);
        }
    }
}
