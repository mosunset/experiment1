import java.util.InputMismatchException;

public class Lesson13_2 {

    // Lesson13_2
    public static void main(String[] args) {
        try {
            int x = Integer.parseInt(args[0]);
            System.out.print("割る数を入力してください: ");

            java.util.Scanner scan = new java.util.Scanner(System.in);
            int y = scan.nextInt();
            System.out.println(x + " / " + y + " = " + (x / y));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("コマンドライン引数が入力されなかったため、例外が発生しました。");
        } catch (NumberFormatException e) {
            System.out.println("数値型に変換する文字列の形式が正しくないため、例外が発生しました。");
        } catch (InputMismatchException e) {
            System.out.println("標準入力が int 型でないため、例外が発生しました。");
        } catch (ArithmeticException e) {
            System.out.println("ゼロ除算をしようとしたため、例外が発生しました。");
        }
    }
}
