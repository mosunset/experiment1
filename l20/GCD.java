public class GCD { // ユークリッド互除法
    public static void main(String[] args) {
        System.out.println(gcd(1071, 1029));
        System.out.println(lcm(7, 5));
        System.out.println(lcm(35, 14));
    }

    public static int gcd(int m, int n) {
        if (n == 0)
            return m;
        return gcd(n, m % n);
    }

    // LCM(Least Common Multiple)
    // gcd(m, n) × lcm(m, n) = m × n
    public static int lcm(int m, int n) {
        return m * n / gcd(m, n);
    }
}
