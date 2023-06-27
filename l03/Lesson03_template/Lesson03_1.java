public class Lesson03_1 {
    public static void main(String[] args) {
        int[] array = { 10, 20, 30, 40, 50 };

        /* -----ここから追加----- */
        System.out.println("配列の長さ : " + array.length);
        int sum = 0;
        for (int temp : array) {
            sum += temp;
        }
        System.out.println("配列の要素の合計 : " + sum);

        /* -----ここまで追加----- */
    }

}