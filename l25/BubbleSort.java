public class BubbleSort {
    // フィールド
    private int[] sort_array;

    // コンストラクタ
    private BubbleSort() {
    }

    public BubbleSort(int[] sort_array) {
        this.sort_array = sort_array;
    }

    public void swap(int x, int y) {
        assignCount += 3;
        int temp = this.sort_array[x];
        this.sort_array[x] = this.sort_array[y];
        this.sort_array[y] = temp;
    }

    public void bubbleSort() {
        for (int i = this.sort_array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (this.compareValue(this.sort_array[j], this.sort_array[j + 1]) == -1) {
                    this.swap(j, j + 1);
                    // 経過を表示 SortTest.display();
                }
            }
        }
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