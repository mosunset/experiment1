public class Study01_5 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int j = 0 ;
        System.out.printf("======= %4d から %4d までの素数 =======\n", a, b);
        if (a < b) { // 昇順用
            for (int i = a; i <= b; i++) {
                if (isPrime(i)) {
                    System.out.printf("%4d", i);

                    j++; // 出力の整形
                    if (j % 10 == 0) {
                        System.out.println();
                    }
                }
            }
        } else { // 降順用
            for (int i = a; i >= b; i--) {
                if (isPrime(i)) {
                    System.out.printf("%4d", i);

                    j++; // 出力の整形
                    if (j % 10 == 0) {
                        System.out.println();
                    }

                }
            }
        }
        System.out.println();
        System.out.println("=========================================");

    }

    public static boolean isPrime(int n) {
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
}
