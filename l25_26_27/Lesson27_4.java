import java.util.Arrays;
import java.util.Random;

public class Lesson27_4 {

    class Result {
        long nAssign = 0;
        long nCompare = 0;
        double aveTime; // [ms]

        Result(long a, long b, double c) {
            nAssign = a;
            nCompare = b;
            aveTime = c;
        }

        void print() {
            System.out.println("\tassignCount:   " + nAssign);
            System.out.println("\tcompareCount:  " + nCompare);
            System.out.println("\taverage time:  " + aveTime + "[ms]");
        }
    }

    interface Proc {
        public void pre(int[] ary);

        public void run();

        public long getNAssign();

        public long getNCompare();
    }

    class Benchmarker {
        boolean isAscending(int[] ary) {
            if (ary.length <= 0)
                return true;
            int x = ary[0];
            for (int i = 1; i < ary.length; i++) {
                if (x > ary[i])
                    return false;
            }
            return true;
        }

        Result run(Proc proc, int[] ary, int m) {
            if (m == 0)
                return null;
            long nAssign = 0, nCompare = 0;
            double sum = 0;
            for (int i = 0; i < m; i++) {
                int[] a = ary.clone();
                proc.pre(a);
                long startTime = System.nanoTime();
                proc.run();
                long stopTime = System.nanoTime();
                sum += ((double) (stopTime - startTime) / 1000000.0);
                if (i == 0) {
                    if (!isAscending(a)) {
                        throw new Error("Sort Failed");
                    }
                    nAssign = proc.getNAssign();
                    nCompare = proc.getNCompare();
                }
            }
            return new Result(nAssign, nCompare, sum / m);
        }
    }

    // フィールド
    static int[] ascendingArray; // 昇順に値が格納された配列
    static int[] descendingArray; // 降順に値が格納された配列
    static int[] randomArray; // ランダムな値が格納された配列
    static Random random; // 乱数生成オブジェクト

    private Proc createInsertionQuickSortProc(int thresh) {
        return new Proc() {
            InsertionQuickSort s;
            int[] a = null;

            public void pre(int[] ary) {
                a = ary;
                s = new InsertionQuickSort(ary);
                s.setThreshold(thresh);
            }

            public void run() {
                s.insertionQuickSort(0, a.length - 1);
            }

            public long getNAssign() {
                return s.getAssignCount();
            }

            public long getNCompare() {
                return s.getCompareCount();
            }
        };
    }

    // メソッド
    public void run(int m, int thresh) {

        Benchmarker bench = new Benchmarker();

        // warm up
        bench.run(createInsertionQuickSortProc(thresh), randomArray.clone(), 20);

        if (false) { // 昇順/降順の配列を試したければ if(true)にしてね
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

                System.out.println("- InsertionQuickSort -");
                bench.run(createInsertionQuickSortProc(thresh), currentArray.clone(), m).print();
            }
        } else {
            System.out.println("=== random     =============================");
            bench.run(createInsertionQuickSortProc(thresh), randomArray.clone(), m).print();
        }
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

    public static void main(String[] args) {
        // if (args.length < 3) {
        // System.out.println("ソートする配列の要素数と繰り返す回数，InsertionQuickSortで使用する閾値を引数で指定してください．");
        // return;
        // }
        int arraySize = 0; // 配列の要素数
        int m = 1000;
        int[] threshs = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
                97 };
        // int thresh = 0;
        // try {
        // arraySize = Integer.parseInt(args[0]);
        // m = Integer.parseInt(args[1]);
        // thresh = Integer.parseInt(args[2]);
        // } catch (NumberFormatException e) {
        // System.out.println("引数には数値を指定してください．");
        // return;
        // }
        for (int i = 100; i <= 10000; i *= 10) {
            arraySize = i;
            System.out.println("配列の要素数: " + arraySize);
            // for (int thresh : threshs) {
            for (int x = 2; x <= 150; x++) {
                int thresh = x;
                // System.out.print("\t繰り返し回数: " + m);
                System.out.print("閾値: " + thresh + " ");
                long seed = 20180720; // 乱数の種
                init(arraySize, seed); // 配列を作る
                new Lesson27_4().run(m, thresh);
            }
        }
    }
}
