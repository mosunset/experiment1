import java.util.Scanner;

public class Lesson13_3 {

    // Lesson13_3
    public static void main(String[] args) {
        int correctCount = 0; // 正常に計算した回数
        int exceptCount = 0; // 例外が発生した回数

        Scanner scan = new java.util.Scanner(System.in);
        while (true) {
            try {

                System.out.print("割られる数を入力してください（exit で終了）: ");
                String str = scan.nextLine();
                if (str.equals("exit")) {
                    System.out.println("終了します．");
                    break;
                }
                int x = Integer.parseInt(str);
                System.out.print("割る整数を有力してください : ");
                int y = Integer.parseInt(scan.nextLine());
                System.out.println(x + " / " + y + " = " + (x / y));
                correctCount++;
            } catch (NumberFormatException e) {
                System.out.println("数値型に変換する文字列の形式が正しくないため、例外が発生しました。");
                exceptCount++;
            } catch (ArithmeticException e) {
                System.out.println("ゼロ除算をしようとしたため、例外が発生しました。");
                exceptCount++;
            } finally {
                System.out.println("正常に計算した回数 : " + correctCount);
                System.out.println("例外が発生した回数 : " + exceptCount);
                System.out.println("-----");
            }
        }
    }
}
