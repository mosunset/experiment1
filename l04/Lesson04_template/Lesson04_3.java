public class Lesson04_3 {
    public static void main(String[] args) {
        System.out.print("整数を入力してください >> ");
        int n = new java.util.Scanner(System.in).nextInt();

        // add here
        int now = 0;
        int next = 1;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = now + next;
            now = next;
            next = temp;
        }
        System.out.println(n + " 番目のフィボナッチ数は " + now + " です");
    }
}
