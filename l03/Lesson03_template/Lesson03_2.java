public class Lesson03_2 {
    public static void main(String[] args) {
        System.out.println(mul(2, 4));
        System.out.println(mul(2, 4, 10));
        System.out.println(mul(2, 4, 10.0));
    }

    /* -----ここから追加----- */
    public static int mul(int x, int y) {
        return x * y;

    }

    public static int mul(int x, int y, int z) {
        return x * y * z;
    }

    public static double mul(int x, int y, double z) {
        return x * y * z;
    }
    /* -----ここまで追加----- */
}