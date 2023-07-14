import java.util.Arrays;
import java.util.Random;

public class Lesson26_3_1 {
	// フィールド
	static final int arraySize = 100; // 配列の要素数

	// メソッド
	public static void main(String[] args) {
		int[] array = new int[arraySize];
		for (int i = 0; i < array.length; i++) {
			int j = (int)(Math.random() * 100);
			array[i] = j;						//ランダム
			//array[i] = array.length - i;		//逆順
		}

		System.out.println("array size: " + arraySize);
		System.out.println();

		int[] array1 = array.clone();
		System.out.println("- InsertionSortX -");
		InsertionSortX is = new InsertionSortX(array1);
		is.startTimer();
		is.insertionSortX(); // ソート
		is.stopTimer();	
		System.out.println("Sort: " + is.checkSort());
		System.out.println("assign count: " + is.getAssignCount());
		System.out.println("compare count: " + is.getCompareCount());
		System.out.println("sort time: " + (double)is.getSortTime() / 1000000.0 + "[ms]");

		int[] array2 = array.clone();
		ShellSort sh = new ShellSort(array2); // シェルソート
		System.out.println("- ShellSort -");
		sh.startTimer();
		sh.shellSort(); // ソート
		sh.stopTimer();
		System.out.println("Sort: " + sh.checkSort());
		System.out.println("assign count: " + sh.getAssignCount());
		System.out.println("compare count: " + sh.getCompareCount());
		System.out.println("sort time: " + (double)sh.getSortTime() / 1000000.0 + "[ms]");

		int[] array3 = array.clone();
		OriginalShellSort osh = new OriginalShellSort(array3); // オリジナルシェルソート
		System.out.println("- OriginalShellSort -");
		osh.startTimer();
		osh.originalShellSort(); // ソート
		osh.stopTimer();
		System.out.println("Sort: " + osh.checkSort());
		System.out.println("assign count: " + osh.getAssignCount());
		System.out.println("compare count: " + osh.getCompareCount());
		System.out.println("sort time: " + (double)osh.getSortTime() / 1000000.0 + "[ms]");

	}
}
