public class FinalTest {
    public static void main(String[] args) {
        final double PI = 3.14; // 定数の宣言 あとに変更できない
        int pie = 5;
        System.out.println("半径" + pie + "cmのパイの面積は、");
        System.out.println(pie * pie * PI);

        System.out.println("パイの半径を倍にします");
        // PI = 10; //エラーになる
        System.out.println("半径" + pie + "cmのパイの面積は、");
        System.out.println(pie * pie * PI);
    }
}