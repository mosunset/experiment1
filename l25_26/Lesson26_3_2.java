import java.util.Arrays;
import java.util.Random;

public class Lesson26_3_2 {
	// フィールド

	// メソッド
	public static void main(String[] args) {
		int[] mixArray = {14, 12, 15, 16, 13, 19, 17, 18, 4, 2, 5, 6, 3, 9, 7, 8};
		int[] biasArray = {18, 4, 14, 5, 12, 6, 15, 3 ,16, 9, 13, 7, 19, 8, 17, 2};

		System.out.println("------random array-------");
		int[] array2 = mixArray.clone();
		ShellSort sh = new ShellSort(array2); // シェルソート
		System.out.println("- ShellSort -");
		sh.startTimer();
		sh.shellSort(); // ソート
		sh.stopTimer();
		System.out.println("Sort: " + sh.checkSort());
		System.out.println("assign count: " + sh.getAssignCount());
		System.out.println("compare count: " + sh.getCompareCount());
		System.out.println("sort time: " + (double)sh.getSortTime() / 1000000.0 + "[ms]");

		System.out.println();
		int[] array3 = mixArray.clone();
		OriginalShellSort osh = new OriginalShellSort(array3); // オリジナルシェルソート
		System.out.println("- OriginalShellSort -");
		osh.startTimer();
		osh.originalShellSort(); // ソート
		osh.stopTimer();
		System.out.println("Sort: " + osh.checkSort());
		System.out.println("assign count: " + osh.getAssignCount());
		System.out.println("compare count: " + osh.getCompareCount());
		System.out.println("sort time: " + (double)osh.getSortTime() / 1000000.0 + "[ms]");

		System.out.println("------bias array-------");
		array2 = biasArray.clone();
		sh = new ShellSort(array2); // シェルソート
		System.out.println("- ShellSort -");
		sh.startTimer();
		sh.shellSort(); // ソート
		sh.stopTimer();
		System.out.println("Sort: " + sh.checkSort());
		System.out.println("assign count: " + sh.getAssignCount());
		System.out.println("compare count: " + sh.getCompareCount());
		System.out.println("sort time: " + (double)sh.getSortTime() / 1000000.0 + "[ms]");

		array3 = biasArray.clone();
		osh = new OriginalShellSort(array3); // オリジナルシェルソート
		System.out.println("- OriginalShellSort -");
		osh.startTimer();
		osh.originalShellSort(); // ソート
		osh.stopTimer();
		System.out.println("Sort: " + osh.checkSort());
		System.out.println("assign count: " + osh.getAssignCount());
		System.out.println("compare count: " + osh.getCompareCount());
		System.out.println("sort time: " + (double)osh.getSortTime() / 1000000.0 + "[ms]");

	}

	public static void display(int[] array) {
		for (int element: array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
