public class Lesson13_1 {

    // Lesson13_1 main
    public static void main(String[] args) {
        while (true) {
            System.out.print("整数を入力してください（exitで終了）: ");
            String str = new java.util.Scanner(System.in).nextLine();
            if (str.equals("exit")) {
                System.out.println("終了します．");
                break;
            }
            try {
                int num = Integer.parseInt(str);
                System.out.println(num);
            } catch (Exception e) {
                System.out.println("例外が発生しました");
            }
        }
    }
}
