import java.util.Arrays;
import java.util.Random;

public class Lesson27_3 {

    class Result {
        long nAssign = 0;
        long nCompare = 0;
        double aveTime; //[ms]
        Result(long a, long b, double c) {
            nAssign = a;
            nCompare = b;
            aveTime = c;
        }
        void print() {
            System.out.println("\tassignCount:   "+nAssign);
            System.out.println("\tcompareCount:  "+nCompare);
            System.out.println("\taverage time:  "+aveTime+"[ms]");
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
            if (ary.length <= 0) return true;
            int x = ary[0];
            for (int i = 1; i < ary.length; i++) {
                if (x > ary[i]) return false;
            }
            return true;
        }
        Result run(Proc proc, int[] ary, int m) {
            if (m == 0) return null;
            long nAssign = 0, nCompare = 0;
            double sum = 0;
            for (int i = 0; i < m; i++) {
                int[] a = ary.clone();
                proc.pre(a);
                long startTime = System.nanoTime();
                proc.run();
                long stopTime = System.nanoTime();
                sum += ((double)(stopTime - startTime) / 1000000.0);
                if (i == 0) {
                    if (!isAscending(a)) {
                        throw new Error("Sort Failed");
                    }
                    nAssign = proc.getNAssign();
                    nCompare = proc.getNCompare();
                }
            }
            return new Result(nAssign, nCompare, sum/m);
        }
    }


    // フィールド
    static int[] ascendingArray;  // 昇順に値が格納された配列
    static int[] descendingArray; // 降順に値が格納された配列
    static int[] randomArray;     // ランダムな値が格納された配列
    static Random random; // 乱数生成オブジェクト

    Proc procBubbleSort = new Proc() {
        BubbleSort s;
        public void pre(int[] ary) {
            s = new BubbleSort(ary);
        }
        public void run() {
            s.bubbleSort();
        }
        public long getNAssign() {
            return s.getAssignCount();
        }
        public long getNCompare() {
            return s.getCompareCount();
        }
    };
    Proc procSelectionSort = new Proc() {
        SelectionSort s;
        public void pre(int[] ary) {
            s = new SelectionSort(ary);
        }
        public void run() {
            s.selectionSort();
        }
        public long getNAssign() {
            return s.getAssignCount();
        }
        public long getNCompare() {
            return s.getCompareCount();
        }
    };
    Proc procShellSort = new Proc() {
        ShellSort s;
        public void pre(int[] ary) {
            s = new ShellSort(ary);
        }
        public void run() {
            s.shellSort();
        }
        public long getNAssign() {
            return s.getAssignCount();
        }
        public long getNCompare() {
            return s.getCompareCount();
        }
    };
    Proc procInsertionSortX = new Proc() {
        InsertionSortX s;
        public void pre(int[] ary) {
            s = new InsertionSortX(ary);
        }
        public void run() {
            s.insertionSortX();
        }
        public long getNAssign() {
            return s.getAssignCount();
        }
        public long getNCompare() {
            return s.getCompareCount();
        }
    };
    Proc procQuickSort = new Proc() {
        QuickSort s;
        int[] a = null;
        public void pre(int[] ary) {
            a = ary; 
            s = new QuickSort(ary);
        }
        public void run() {
            s.quickSort(0, a.length-1);
        }
        public long getNAssign() {
            return s.getAssignCount();
        }
        public long getNCompare() {
            return s.getCompareCount();
        }
    };
    Proc procInsertionQuickSort = new Proc() {
        InsertionQuickSort s;
        int[] a = null;
        public void pre(int[] ary) {
            a = ary; 
            s = new InsertionQuickSort(ary);
            s.setThreshold(5);
        }
        public void run() {
            s.insertionQuickSort(0, a.length-1);
        }
        public long getNAssign() {
            return s.getAssignCount();
        }
        public long getNCompare() {
            return s.getCompareCount();
        }
    };


    // メソッド
    public void run(int m) {

        Benchmarker bench = new Benchmarker();
        for (int i = 0; i < 3; i++) { // ソートする配列を決める
            int[] currentArray = null; // ソートする配列
            if (i == 0) {
                currentArray = ascendingArray;
                System.out.println("=== ascending  =============================")	;
            } else if (i == 1) {
                currentArray = descendingArray;
                System.out.println("=== descending =============================")	;
            } else if (i == 2) {
                currentArray = randomArray;
                System.out.println("=== random     =============================")	;
            }

            System.out.println("- BubbleSort -");
            bench.run(procBubbleSort, currentArray.clone(), m).print();

            System.out.println("- SelectionSort -");
            bench.run(procSelectionSort, currentArray.clone(), m).print();

            System.out.println("- ShellSort -");
            bench.run(procShellSort, currentArray.clone(), m).print();

            System.out.println("- InsertionSortX -");
            bench.run(procInsertionSortX, currentArray.clone(), m).print();

            System.out.println("- QuickSort -");
            bench.run(procQuickSort, currentArray.clone(), m).print();

            System.out.println("- InsertionQuickSort -");
            bench.run(procInsertionQuickSort, currentArray.clone(), m).print();
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
            ascendingArray[i] = ascendingArray[i-1] + random.nextInt(10);
            // 1つ後より0--9小さい数
            descendingArray[descendingArray.length - 1 - i]
                = descendingArray[descendingArray.length - i] + random.nextInt(10);
            // ランダム
            randomArray[i] = random.nextInt(randomArray.length * 3);
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("ソートする配列の要素数と繰り返す回数を引数で指定してください．");
            return;
        }
        int arraySize = 0; // 配列の要素数
        int m = 0;
        try {
            arraySize = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("引数には数値を指定してください．");
            return;
        }
        long seed = 20180720;  // 乱数の種
        init(arraySize, seed); // 配列を作る
        new Lesson27_3().run(m);
    }
}
