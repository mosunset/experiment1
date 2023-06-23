public class Hanoi { // ハノイの塔
    public static void main(String[] args) {
        hanoi(Integer.parseInt(args[0]), 'A', 'B', 'C');
    }

    // n 枚の円盤を from から to まで移動させるメソッド
    static void hanoi(int n, char from, char other, char to) {
        if (n == 0)
            return; // 基底条件
        // n-1 枚の円盤を from から other に移動させる
        hanoi(n - 1, from, to, other);
        // n 枚目の円盤を from から to に移動させる
        System.out.println("Move disk " + n +
                ": from " + from + " to " + to);
        // n-1 枚の円盤を other から to に移動させる
        hanoi(n - 1, other, from, to);
    }
}
