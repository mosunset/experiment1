public class Lesson03_3 {
    public static void main(String[] args) {
        int[] scores = { 55, 84, 73, 65, 49, 51, 75, 92, 76, 99 };

        System.out.println("最高点 : " + maxScore(scores) + "点");
        System.out.println("最低点 : " + minScore(scores) + "点");
        System.out.println("平均点 : " + aveScore(scores) + "点");
    }

    /* -----ここから追加----- */
    public static int maxScore(int[] temp) {
        int tempmax = 0;
        for (int loop : temp) {
            tempmax = Math.max(loop, tempmax);
        }
        return tempmax;

    }

    public static int minScore(int[] temp) {
        int tempmin = 100;
        for (int loop : temp) {
            tempmin = Math.min(loop, tempmin);
        }
        return tempmin;
    }

    public static double aveScore(int[] temp) {
        double sum = 0;
        for (double loop : temp) {
            sum += loop;
        }
        return sum / temp.length;
    }

    /* -----ここまで追加----- */

}