public class Lesson07_5 {
    public static void main(String[] args) {
        int[] even = { 0, 2, 4, 6, 8, 10 };
        int[] odd = { 1, 3, 5, 7, 9, 11 };

        // add here
        CalArray cal1 = new CalArray();
        cal1.name = "Even";
        cal1.add(even);
        cal1.mul(even);
        cal1.output();

        CalArray cal2 = new CalArray();
        cal2.name = "Odd";
        cal2.add(odd);
        cal2.mul(odd);
        cal2.output();

        CalArray cal3 = new CalArray();
        cal3.name = "Even & Odd";
        int[] temp = new int[even.length + odd.length];

        System.arraycopy(even, 0, temp, 0, even.length);
        System.arraycopy(odd, 0, temp, even.length, odd.length);

        cal3.add(temp);
        cal3.mul(temp);
        cal3.output();

    }
}
