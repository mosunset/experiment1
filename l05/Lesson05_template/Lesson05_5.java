import java.util.Random;

public class Lesson05_5 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);// 残ってる石の数
        int playerID = 1;// playerを入れ替えるための引数
        java.util.Scanner scan = new java.util.Scanner(System.in);
        top: while (true) {
            System.out.print("player" + playerID + " ... " + n + " >>> ");
            // Add here========================== 1を取ったら勝利
            int put;
            if (playerID == 2) {
                put = new Random().nextInt(3) + 1;
                System.out.println(put);
            } else {
                put = scan.nextInt();
            }
            if (0 < put && put < 4) {
                for (int i = 1; i <= put; i++) {

                    System.out.print(n + " ");
                    if (n <= 1) {
                        System.out.println();
                        System.out.println("player" + playerID + " の勝利です");
                        break top;
                    } else {
                        n--;
                    }
                }
                if (playerID == 1) {
                    playerID = 2;
                } else {
                    playerID = 1;
                }

            } else {
                System.out.print("無効な入力です.1,2,3のいずれかを入力してください");
            }
            System.out.println();
            // =========================================
        }
    }
}
