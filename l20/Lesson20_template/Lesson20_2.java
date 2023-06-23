public class Lesson20_2 {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        System.out.println("10進数 : " + num);
        System.out.print("2進数  : ");
        binary(num);
        System.out.println();
    }

    // -----add here-----
    public static void binary(int num) {
        if(num <= 0){
            System.out.print("0");
        }else if (num <= 1) {
            System.out.print("1");
        } else {
            int temp1 = num / 2;
            int temp2 = num % 2;
            binary(temp1);
            System.out.print(Integer.valueOf(temp2));
        }
    }
}
