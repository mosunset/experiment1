import java.util.Arrays;
import java.util.Random;

public class Lesson27_2 {
		// フィールド
		static int[] ascendingArray;  // 昇順に値が格納された配列
		static int[] descendingArray; // 降順に値が格納された配列
		static int[] randomArray;     // ランダムな値が格納された配列
		static Random random; // 乱数の種

        private static boolean isAscending(int[] ary) {
            if (ary.length <= 0) return true;
            int x = ary[0];
            for (int i = 1; i < ary.length; i++) {
                if (x > ary[i]) return false;
            }
            return true;
        }

		// メソッド
		public static void main(String[] args) {
			int arraySize = 10;  // 配列のサイズ
			long seed = 20180720;  // 乱数の種
			init(arraySize, seed); // 配列を作る
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
				System.out.println(Arrays.toString(currentArray)); // 配列を表示する
                int[] ary = null;

                BubbleSort bs = new BubbleSort(ary = currentArray.clone()); //挿入ソート
				System.out.printf("%-20s : \t", "BubbleSort");
				bs.bubbleSort(); // ソート
                if (isAscending(ary)) {
				    System.out.printf("assign count:%3d", bs.getAssignCount());
				    System.out.printf("\tcompare count:%3d", bs.getCompareCount());
                } else {
                    System.out.print("Failed: "+Arrays.toString(ary));
                }
                System.out.println();

                SelectionSort ss = new SelectionSort(ary = currentArray.clone()); //挿入ソート
				System.out.printf("%-20s : \t", "SelectionSort");
				ss.selectionSort(); // ソート
                if (isAscending(ary)) {
				    System.out.printf("assign count:%3d", ss.getAssignCount());
				    System.out.printf("\tcompare count:%3d", ss.getCompareCount());
                } else {
                    System.out.print("Failed: "+Arrays.toString(ary));
                }
                System.out.println();

                ShellSort shs = new ShellSort(ary = currentArray.clone()); //挿入ソート
				System.out.printf("%-20s : \t", "ShellSort");
				shs.shellSort(); // ソート
                if (isAscending(ary)) {
				    System.out.printf("assign count:%3d", shs.getAssignCount());
				    System.out.printf("\tcompare count:%3d", shs.getCompareCount());
                } else {
                    System.out.print("Failed: "+Arrays.toString(ary));
                }
                System.out.println();

				InsertionSortX is = new InsertionSortX(ary = currentArray.clone()); //挿入ソート
				System.out.printf("%-20s : \t", "InsertionSortX");
				is.insertionSortX(); // ソート
                if (isAscending(ary)) {
				    System.out.printf("assign count:%3d", is.getAssignCount());
				    System.out.printf("\tcompare count:%3d", is.getCompareCount());
                } else {
                    System.out.print("Failed: "+Arrays.toString(ary));
                }
                System.out.println();

				QuickSort qu = new QuickSort(ary = currentArray.clone()); // クイックソート
				System.out.printf("%-20s : \t", "QuickSort");
				qu.quickSort(0, currentArray.length-1); // ソート
                if (isAscending(ary)) {
				    System.out.printf("assign count:%3d", qu.getAssignCount());
				    System.out.printf("\tcompare count:%3d", qu.getCompareCount());
                } else {
                    System.out.print("Failed: "+Arrays.toString(ary));
                }
                System.out.println();

				InsertionQuickSort iqu = new InsertionQuickSort(ary = currentArray.clone()); // クイックソート+挿入ソート
                iqu.setThreshold(5);
				System.out.printf("%-20s : \t", "InsertionQuickSort");
				iqu.insertionQuickSort(0, currentArray.length-1); // ソート
                if (isAscending(ary)) {
				    System.out.printf("assign count:%3d", iqu.getAssignCount());
				    System.out.printf("\tcompare count:%3d", iqu.getCompareCount());
                } else {
                    System.out.print("Failed: "+Arrays.toString(ary));
                }
                System.out.println();
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
}
