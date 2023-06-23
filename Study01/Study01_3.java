import java.util.ArrayList;
import java.util.Scanner;

public class Study01_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        top: while (true) {
            System.out.print("1 以上 1000 以下の自然数もしくは exit を入力してください：");
            String input = scanner.next();

            if (input.equals("exit")) { // 終了チェック
                System.out.println("処理を終了します");
                break top;
            } else {
                int number = Integer.parseInt(input);

                if (checkinput(number)) { // 入力数字チェック
                    System.out.print(number + " = ");

                    if (number == 1) {
                        System.out.println(1);
                    } else {
                        ArrayList<Integer> list = new ArrayList<Integer>(); // 戻り値受け取りのための配列
                        
                        list = factorization(number);
                        int listsize = list.size();

                        for (int i = 0; i < listsize; i++) {
                            int getlist = list.get(i);

                            if (i % 2 == 0) { // 出力の整形---はじめ---
                                System.out.print(getlist);
                            } else {

                                if (getlist != 1) {
                                    System.out.print("^" + getlist);
                                }

                                if (i != listsize - 1) {
                                    System.out.print(" * ");
                                }
                            } // 出力の整形---終わり---
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("1 以上 1000 以下の自然数を入力してください");
                }
            }
        }
    }

    public static boolean checkinput(int input) {

        if (1 <= input && input <= 1000) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Integer> factorization(int n) {

        // 自然数nを因数分解して、素因数とその指数を返す。

        ArrayList<Integer> factors = new ArrayList<Integer>(); // 因数を格納するための配列
        int d = 2;
        while (d * d <= n) { // dがnの平方根以下の間、以下を繰り返す

            int count = 0;
            while ((n % d) == 0) { // nがdで割り切れる限り、以下を繰り返す
                count += 1; // dの指数をカウントアップ
                n /= d; // nをdで割り、次の素因数を探索
            }

            if (count > 0) { // dがnの素因数であれば、リストに追加する
                factors.add(d);
                factors.add(count);
            }
            d += 1; // 次の素数を探索するため
        }

        if (n > 1) { // nが1より大きい場合、残りの素因数はn自身である
            factors.add(n);
            factors.add(1);
        }
        return factors;
    }

}
