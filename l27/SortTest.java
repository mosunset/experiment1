public class SortTest {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        setIntArray(array1, 100);

        System.out.println("Quick Sort");
        QuickSort qs = new QuickSort(array1);
        display(array1);
        qs.quickSort();
        display(array1);
    }

    public static int[] cloneIntArray(int[] array) {
        int[] clone = new int[array.length];
        int i = 0;
        for (int element : array) {
            clone[i++] = element;
        }
        return clone;
    }

    public static void display(int[] array) {
        for (int element : array) {
            System.out.printf("%4d", element);
        }
        System.out.println();
    }

    public static void setIntArray(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * n);
        }
    }
}
