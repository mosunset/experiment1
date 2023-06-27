public class Lesson09_5 {
    public static void main(String[] args) {
        Marking m = new Marking();
        int score_list[] = new int[args.length];

        // 入力されたコマンドライン引数の数値をint型に変換し格納する
        for (int list_i = 0; list_i < args.length; list_i++) {
            score_list[list_i] = Integer.parseInt(args[list_i]);
        }

        for (int i = 0; i < score_list.length; i++) {
            m.setScore(i, score_list[i]);
        }

        System.out.println("Sum: " + m.computeSum());
    }
}
