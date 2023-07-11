public class InsertionSort {
    private int[] sort_array;

    private InsertionSort() {
    }

    public InsertionSort(int[] array) {
        this.sort_array = array;
    }

    private void swap(int x, int y) {
        assignCount += 3;
        int temp = this.sort_array[x];
        this.sort_array[x] = this.sort_array[y];
        this.sort_array[y] = temp;
    }

    // Lesson25_1
    public void insertionSort() {
        for (int i = 1; i < this.sort_array.length; i++) {
            int key = this.sort_array[i];
            int j = i - 1;

            while (j >= 0 && this.compareValue(this.sort_array[j] , key) == -1) {
                this.swap(j, j + 1);
                j--;
            }

            this.sort_array[j + 1] = key;
            // 経過を表示
            // display(sort_array);
        }
    }

    // Lesson25_2
    public boolean checkSort() {
        for (int i = 0; i < this.sort_array.length - 1; i++) {
            if (this.sort_array[i] > this.sort_array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Lesson25_3

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

    // Lesson25_4
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