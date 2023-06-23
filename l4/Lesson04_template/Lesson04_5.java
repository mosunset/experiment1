public class Lesson04_5 {
    public static boolean isPrime(int n) {
        // add here
        int temp;
        if (n < 2) {
            return false;
        } else if (n == 2) {
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

    public static int countPrime(int upper) {
        // add here
        var count = 0;
        for (int i = 2; i <= upper; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static void printAll(int upper) {
        // add here
        for (int i = 2; i <= upper; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print("整数を入力してください >> ");
        int n = new java.util.Scanner(System.in).nextInt();
        System.out.println(n + " 以下に素数は " + countPrime(n) + " 個あります");
        printAll(n);
    }
}
