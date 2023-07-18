public class SortTest {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        setIntArray(array1, 100);
        int[] array3 = cloneIntArray(array1);
        int[] array4 = cloneIntArray(array1);

        System.out.println("Insert Sort");
        InsertionSortX Is = new InsertionSortX(array3);
        display(array3);
        Is.insertionSortX();
        display(array3);

        System.out.println("Shell Sort");
        ShellSort sh = new ShellSort(array4);
        display(array4);
        sh.shellSort();
        display(array4);
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
