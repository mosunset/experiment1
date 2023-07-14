class InsertionSortX {
    private int[] sort_array;

    private InsertionSortX() {
    }

    public InsertionSortX(int[] sort_array) {
        this.sort_array = sort_array;
    }

    public void insertionSortX() {
        int in, out, temp;
        for (out = 1; out < this.sort_array.length; out++) {
            temp = this.sort_array[out];
            assignCount++;
            in = out;
            while (in > 0 && this.compareValue(this.sort_array[in - 1], temp) == -1) {
                this.sort_array[in] = this.sort_array[in - 1];
                assignCount++;
                in--;
            }
            this.sort_array[in] = temp;
            assignCount++;
            // 経過を表示 
            //this.display(sort_array);
        }
    }

    // Lesson26_2
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
    // Lesson26_3

    private long timeStart;
    private long timeStop;

    public void startTimer() {
        timeStart = System.nanoTime();
    }

    public void stopTimer() {
        timeStop = System.nanoTime();
    }

    public long getSortTime() {
        return timeStop - timeStart;
    }

    public void display(int[] array) {
        for (int element : array) {
            System.out.printf("%3d",element);
        }
        System.out.println();
    }
}
