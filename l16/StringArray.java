import java.util.Arrays;
import java.util.List;

public class StringArray {
    public static void main(String[] args) {
        StringArray sa = new StringArray(5);
        sa.printAll();

        for (int i = 0; i < sa.length; i++) {
            sa.set("Element-" + i, i);
        }
        sa.printAll();
        System.out.println("length = " + sa.length);
        System.out.println("get(3): " + sa.get(3));
        System.out.println(sa);
    }

    // フィールド
    private String[] array;
    public final int length;

    // コンストラクタ
    public StringArray(int size) {
        this.length = size;
        this.array = new String[this.length];
    }

    private StringArray() {
        this.length = 0;
    }

    // メソッド
    public boolean set(String obj, int index) {
        if (index < 0 || index > this.length - 1) {
            System.out.println("ArrayIndexOutOfBoundsException!");
            return false;
        }
        this.array[index] = obj;
        return true;
    }

    public String get(int index) {
        if (index < 0 || index > this.length - 1) {
            System.out.println("ArrayIndexOutOfBoundsException!");
            return null;
        }
        return this.array[index];
    }

    public void printAll() {
        for (int i = 0; i < this.length; i++) {
            System.out.println("this.array[" + i + "] = " + this.array[i]);
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (String s : this.array) {
            sb.append("this.array[" + (i++) + "] = " + s + "\n");
        }
        return sb.toString();
    }

    // 課題用の初期化
    public void initForLessons() {
        for (int i = 0; i < this.length; i++) {
            this.set("ARRAY-" + i, i);
        }
        this.set("Imamura", 0);
        this.set("Kikawa", 1);
        this.set("Kubota", 2);
        this.set("Tagashira", 3);
        this.set("Watanabe", 4);
        this.set("Kobayashi", 5);
        this.set("Suenobu", 6);
        this.set("Nakayama", 7);
    }

    public int search(String str) {
        for (int i = 0; i < array.length; i++) {
            if (str.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public void exchange(int index1, int index2) {
        String temp;
        try {
            temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException!");
        }
    }

    public int replace(String obj1, String obj2) {
        int temp = 0;
        System.out.println(obj1 + " -> " + obj2);
        for (int i = 0; i < array.length; i++) {
            if (obj1.equals(array[i])) {
                array[i] = obj2;
                temp++;
            }
        }
        if (temp > 0) {
            return temp;
        }
        return -1;
    }

    public StringArray trimming(int from, int to) {// {0,1,2,3,4,5,6},2,5 ->1-4 ,4
        StringArray sa = null;// = new StringArray();
        try {
            int arraysize = to - from + 1;
            sa = new StringArray(arraysize);
            for (int i = 0; i < arraysize; i++) {
                sa.set(array[from + i], i);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException!");
            return null;
        } catch (NegativeArraySizeException e) {
            System.out.println("NegativeArraySizeException!");
            return null;
        }

        return sa;
    }

    public void sort() {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int x = i + 1; x < len; x++) {
                int temp = array[x].compareTo(array[i]);
                if (temp < 0) {
                    exchange(i, x);
                }
            }
        }

        // int len = array.length;
        // for (int i = 0; i < len - 1; i++) {
        // int minIndex = i;

        // for (int x = i + 1; x < len; x++) {
        // if (array[x].compareTo(array[i]) < 0) {
        // minIndex = x;
        // }
        // }
        // exchange(i, minIndex);
        // }
    }
}
