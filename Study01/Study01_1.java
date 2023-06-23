public class Study01_1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // 上半分の砂時計を出力
        for (int i = 0; i <= n; i++) { //真ん中描画のためイコール付き条件
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (n-i)*2+1; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        // 下半分の砂時計を出力
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n-i)-1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i*2+3; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
