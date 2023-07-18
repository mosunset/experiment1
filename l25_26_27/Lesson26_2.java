	import java.util.Arrays;
	import java.util.Random;

	public class Lesson26_2 {
	// フィールド
	static int[] ascendingArray;  // 昇順に値が格納された配列
	static int[] descendingArray; // 降順に値が格納された配列
	static int[] randomArray;     // ランダムな値が格納された配列
	static Random random; // 乱数の種

	// メソッド
	public static void main(String[] args) {
		int arraySize = 10;  // 配列のサイズ
		long seed = 20230714;  // 乱数の種
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

			int[] array = currentArray.clone();
			InsertionSortX is = new InsertionSortX(array); // 挿入ソート
			System.out.println("- InsertionSortX -");
			is.insertionSortX(); // ソート
			display(array);    // 表示
			System.out.println("Sort: " + is.checkSort());
			System.out.println("assign count: " + is.getAssignCount());
			System.out.println("compare count: " + is.getCompareCount());

			array = currentArray.clone();
			ShellSort sh = new ShellSort(array); // シェルソート
			System.out.println("- ShellSort -");
			sh.shellSort(); // ソート
			display(array);    // 表示
			System.out.println("Sort: " + sh.checkSort());
			System.out.println("assign count: " + sh.getAssignCount());
			System.out.println("compare count: " + sh.getCompareCount());

			array = currentArray.clone();
			OriginalShellSort osh = new OriginalShellSort(array); // オリジナルシェルソート
			System.out.println("- OriginalShellSort -");
			osh.originalShellSort(); // ソート
			display(array);    // 表示
			System.out.println("Sort: " + osh.checkSort());
			System.out.println("assign count: " + osh.getAssignCount());
			System.out.println("compare count: " + osh.getCompareCount());
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
	public static void display(int[] array) {
		for (int element: array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
