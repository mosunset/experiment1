public class Lesson04_4 {
    public static boolean isPrime(int n) {
        // add here
        int temp;
        if(n < 2){
            return false;
        }else if (n == 2) {
            return true;
        } else {
            for (int i = 2; i <= (int) (n / 2); i++) {
                temp = n % i;
                if (temp == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print("整数を入力してください >> ");
        int n = new java.util.Scanner(System.in).nextInt();
        if (isPrime(n)) {
            System.out.println(n + " は素数です");
        } else {
            System.out.println(n + " は素数ではありません");
        }
    }
}
