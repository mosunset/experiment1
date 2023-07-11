public class SelectionSort {
    // フィールド
    private int[] sort_array;

    // コンストラクタ
    private SelectionSort() {
    }

    public SelectionSort(int[] sort_array) {
        this.sort_array = sort_array;
    }

    public void swap(int x, int y) {
        assignCount += 3;
        int temp = this.sort_array[x];
        this.sort_array[x] = this.sort_array[y];
        this.sort_array[y] = temp;
    }

    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < this.sort_array.length - 1; out++) {
            min = out;
            for (in = out + 1; in < this.sort_array.length; in++) {
                if (this.compareValue(this.sort_array[in], this.sort_array[min]) == 1) {
                    min = in;
                }
            }
            this.swap(out, min);
            // 経過を表示
            // display(sort_array);
        }
    }

    // public void doubleselectionSort() {
    // int left = 0;
    // int right = this.sort_array.length - 1;

    // while (left < right) {
    // int min = left;
    // int max = right;

    // // 未ソート部分で最小値と最大値を探す
    // for (int i = left; i <= right; i++) {
    // if (this.sort_array[i] < this.sort_array[min]) {
    // min = i;
    // } else if (this.sort_array[i] > this.sort_array[max]) {
    // max = i;
    // }
    // }

    // // 最小値を左端の要素と交換
    // this.swap(left, min);

    // // 最大値が左端にあった場合、そのインデックスを更新
    // if (max == left) {
    // max = min;
    // }

    // // 最大値を右端の要素と交換
    // this.swap(right, max);

    // // 未ソート部分を狭めるために左側を増加し、右側を減少させる
    // left++;
    // right--;

    // // 経過を表示
    // // display(sort_array);
    // }
    // }

    // 途中経過表示
    public static void display(int[] array) {
        for (int element : array) {
            System.out.printf("%4d", element);
        }
        System.out.println();
    }

    public boolean checkSort() {
        for (int i = 0; i < this.sort_array.length - 1; i++) {
            if (this.sort_array[i] > this.sort_array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    protected long timeStart;
    protected long timeStop;

    public void startTimer() {
        timeStart = System.nanoTime();
    }

    public void stopTimer() {
        timeStop = System.nanoTime();
    }

    public long getSortTime() {
        return timeStop - timeStart;
    }

    protected int assignCount;
    protected int compareCount;

    public int getAssignCount() {
        return assignCount;
    }

    public int compareValue(int n1, int n2) {
        compareCount++;
        if (n1 < n2) {
            return 1;
        } else if (n1 > n2) {
            return -1;
        }
        return 0;
    }

    public int getCompareCount() {
        return compareCount;
    }
}
