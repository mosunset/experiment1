public class SortTest {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        setIntArray(array1, 100);
        int[] array2 = cloneIntArray(array1);

        System.out.println("Bubble Sort");
        BubbleSort bs = new BubbleSort(array1);
        display(array1);
        bs.bubbleSort();
        display(array1);

        System.out.println("Selection Sort");
        SelectionSort ss = new SelectionSort(array2);
        display(array2);
        ss.selectionSort();
        display(array2);

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
