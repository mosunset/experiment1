import java.util.Scanner;

public class Lesson05_1 {
    public static void main(String[] args) {
        // Add here==========================
        System.out.println("好きな文字列を入力してください.");
        Scanner Scanner = new Scanner(System.in);
        String input = "";
        boolean checkexit = true;
        while (checkexit) {
            System.out.print("input : ");
            input = Scanner.nextLine();
            if (!input.equals("exit")) {
                System.out.println("output : " + input);
            } else {
                checkexit = false;
            }
        }
        System.out.println("プログラムを終了します.");
        // =========================================
    }
}
