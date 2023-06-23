public class Lesson05_3 {
    public static void main(String[] args) {
        // Add here==========================
        if (args.length == 2) {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            if (y == 0) {
                System.out.println("ゼロ除算です");
            } else {
                System.out.println(x + " を " + y + " で割った商は " + x / y + " です");
                System.out.println(x + " を " + y + " による余剰は " + x % y + " です");
            }
        } else {
            System.out.println("コマンドライン引数を2つ入力してください");
        }

        // =========================================
    }
}
