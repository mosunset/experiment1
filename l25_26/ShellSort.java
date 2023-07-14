class ShellSort {
    private int[] sort_array;

    private ShellSort() {

    }

    public ShellSort(int[] sort_array) {
        this.sort_array = sort_array;
    }

    public void shellSort() {
        int in, out, temp, h;
        h = 1;
        while (h < this.sort_array.length / 3) {
            h = h * 3 + 1;// Kunth's interval sequence
        }
        while (h > 0) {
            // 動作確認用 System.out.println("H = " + h);
            for (out = h; out < this.sort_array.length; out++) {
                temp = this.sort_array[out];
                in = out;
                while (in > h - 1 && this.sort_array[in - h] > temp) {
                    this.sort_array[in] = this.sort_array[in - h];
                    in -= h;
                }
                this.sort_array[in] = temp;
                // 経過を表示
                // SortTest.display(sort_array);
            }
            h = (h - 1) / 3; // Kunth's interval sequence
        }

    }
}
