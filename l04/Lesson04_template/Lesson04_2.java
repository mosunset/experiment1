public class Lesson04_2 {
    public static void main(String[] args) {

        int sum = 0;

        truecheck: while (true) {

            System.out.print("整数または exit を入力してください >> ");
            String input = new java.util.Scanner(System.in).nextLine();

            // add here
            if (input.equals("exit")) {
                break truecheck;
            } else {
                sum += Integer.parseInt(input);
                System.out.println(sum);
            }
        }
    }
}
