public class Lesson04_1 {
    public static void main(String[] args) {
        System.out.print("出力する三角形の高さを入力してください >> ");
        int height = new java.util.Scanner(System.in).nextInt();

        for(int y =1;y<=height;y++){
            for (int x =1;x<=y;x++){
                System.out.print("*");
            }
            System.out.println();
        }

        //add here
        
    }
}
