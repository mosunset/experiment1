class QuickSort {
    private int[] sort_array;

    private QuickSort() {
    }

    public QuickSort(int[] sort_array) {
        this.sort_array = sort_array;
    }

    public void swap(int i, int j) {
        int temp = this.sort_array[i];
        this.sort_array[i] = this.sort_array[j];
        this.sort_array[j] = temp;
    }

    public void quickSort() {
        this.quickSort(0, this.sort_array.length - 1);
    }

    public void quickSort(int from, int to) {
        if (from >= to) {
            return;// 基底条件(base case)
        }
        int pivot = this.sort_array[(from + to) / 2];
        // System.out.print("pivot = " + pivot); // 動作確認用
        int left = from;
        int right = to;
        // System.out.println(", from = "+from+", to " + to); // 動作確認用
        while (left <= right) {
            while (this.sort_array[left] < pivot) {
                left++;
            }
            while (this.sort_array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                this.swap(left, right);
                // SortTest.display(sort_array); // 経過の表示
                left++;
                right--;
            }
        }
        this.quickSort(from, right);
        this.quickSort(left, to);
    }

    // Lesson27_2
    private int assignCount;
    private int compareCount;

    public int getAssignCount() {
        return assignCount;
    }

    public int getCompareCount() {
        return compareCount;
    }

    private int compareValue(int n1, int n2) {
        compareCount++;
        if (n1 < n2) {
            return 1;
        } else if (n1 > n2) {
            return -1;
        }
        return 0;
    }

    public boolean checkSort() {
        for (int i = 0; i < this.sort_array.length - 1; i++) {
            if (this.sort_array[i] > this.sort_array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}