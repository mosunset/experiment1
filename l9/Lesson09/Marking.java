class Marking {
    private int score[] = new int[10];

    // 環境によって違う配列の初期値を統一する目的で初期化を行う. 配列の初期値は0とする.
    // Add here
    Marking() {
        for (int c = 0; c < score.length; c++) {
            score[c] = 0;
        }
    }

    void setScore(int array_num, int score) {
        if (score < 0 || 10 < score) {
            throw new IllegalArgumentException(score + "が0〜10の値でないため、処理を中断します");
        } else {
            this.score[array_num] = score;
        }
    }

    int computeSum() {
        int temp = 0;

        for (int s : this.score) {
            temp += s;
        }
        return temp;
    }
}
