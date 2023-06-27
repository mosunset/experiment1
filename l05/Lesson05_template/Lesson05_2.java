public class Lesson05_2 {
    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);// 高さ
        // Add here==========================

        int inputx1 = input - 1;
        int inputx3 = 0;
        for (int y = 0; y < input; y++) {
            for (int x1 = inputx1; x1 > 0; x1--) {
                System.out.print(" ");
            }
            for(int x2 = 0;x2<input - inputx1;x2++){
                System.out.print("*");
            }
            for(int x3 = 0;x3<inputx3;x3++){
                System.out.print("*");
            }
            inputx1--;
            inputx3++;
            System.out.println();
        }

        // =========================================
    }
}
