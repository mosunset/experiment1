public class MethodTest3 {
    public static void main(String[] args) {
        int x = 100;
        int y = 10;
        int ans = add(x, y);
        System.out.println(x + " + " + y + " = " + ans);
    }

    public static int add(int x, int y) {
        int ans = x + y;
        return ans;
    }
}
