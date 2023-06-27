public class Lesson03_5 {
    public static void main(String[] args) {
        String[] array = { "l", "i", "s", "t", "e", "n" };
        printArray(array);

        System.out.println("0 番目の要素と 2 番目の要素を交換");
        swap(array, 0, 2);
        printArray(array);

        System.out.println("3 番目の要素を削除");
        String str = delete(array, 3);
        printArray(array);

        System.out.println("配列の 5 番目に先ほど削除した文字列を追加");
        rewrite(array, str, 5);
        printArray(array);
    }

    /* -----ここから追加----- */
    public static void swap(String[] array, int m, int n) {
        String temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }

    public static String delete(String[] array, int m) {
        int s = 0;
        String t = "";
        for (int i = 0; i < array.length; i++) {
            if (i != m) {
                array[s] = array[i];
                s++;
            } else {
                t = array[i];
            }

        }
        array[array.length - 1] = " ";
        return t;
    }

    public static void rewrite(String[] array, String s, int m) {
        array[m] = s;
    }

    /* -----ここまで追加----- */

    // 配列の要素を結合して出力
    public static void printArray(String[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str += array[i];
        }
        System.out.println(str);
    }
}