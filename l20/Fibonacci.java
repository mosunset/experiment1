public class Fibonacci { // フィボナッチ数列
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(count);
    }

    public static int fibonacci(int n) {
        count++;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
