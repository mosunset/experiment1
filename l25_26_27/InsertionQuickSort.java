public class InsertionQuickSort {
    private int threshold;
    private int[] sort_array;

    public InsertionQuickSort(int[] sort_array) {
        this.sort_array = sort_array;
    }

    public void setThreshold(int thresh) {
        this.threshold = thresh;
    }

    public void swap(int i, int j) {
        assignCount += 3;
        int temp = this.sort_array[i];
        this.sort_array[i] = this.sort_array[j];
        this.sort_array[j] = temp;
    }

    public void insertionQuickSort(int from, int to) {
        if (Math.abs(to - from) >= this.threshold) {
            if (from >= to) {
                return;// 基底条件(base case)
            }
            int pivot = this.sort_array[(from + to) / 2];
            // System.out.print("pivot = " + pivot); // 動作確認用
            int left = from;
            int right = to;
            // System.out.println(", from = " + from + ", to " + to); // 動作確認用
            while (left <= right) {
                while (this.compareValue(this.sort_array[left], pivot) == -1) {
                    left++;
                }
                while (this.compareValue(this.sort_array[right], pivot) == 1) {
                    right--;
                }
                if (left <= right) {
                    this.swap(left, right);
                    // SortTest.display(sort_array); // 経過の表示
                    left++;
                    right--;
                }
            }
            this.insertionQuickSort(from, right);
            this.insertionQuickSort(left, to);
        } else {
            insertionSortX(from, to);
        }
    }

    private void insertionSortX(int left, int right) {
        int in, out, temp;
        for (out = left + 1; out <= right; out++) {
            temp = this.sort_array[out];
            assignCount++;
            in = out;
            while (in > left && this.compareValue(this.sort_array[in - 1], temp) == 1) {
                this.sort_array[in] = this.sort_array[in - 1];
                assignCount++;
                in--;
            }
            this.sort_array[in] = temp;
            assignCount++;
        }
    }

    public void display() {
        for (int element : this.sort_array) {
            System.out.printf("%3d", element);
        }
        System.out.println();
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
        if (n1 > n2) {
            return 1;
        } else if (n1 < n2) {
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
