import java.util.*;

public class Study02 {
    public static void main(String[] args) {
        Drink d1 = new Drink("ソーダ", 130);
        Drink d2 = new Drink("コーラ", 130);
        Drink d3 = new Drink("天然水", 100);
        Drink d4 = new Drink("烏龍茶", 120);

        VendingMachine m = new VendingMachine();

        m.registDrink(1, d1, 1);
        m.registDrink(1, d2, 2); // エラー
        m.registDrink(2, d2, 2);
        m.registDrink(3, d3, 5);
        m.registDrink(5, d4, 2);

        m.printInfo();

        Scanner scan = new Scanner(System.in);

        int input = 0;
        int in_coin = 0;
        int by_drink = 0;

        top: while (true) {
            System.out.println();
            System.out.println("行いたい操作を指定してください");
            System.out.print("(1: お金の投入, 2: 飲み物の購入, 3: お釣りの返却, 4: 終了) > ");
            input = scan.nextInt();

            if (input == 1) { // お金の投入
                System.out.print("投入する金額を指定してください > ");
                in_coin = scan.nextInt();
                m.insertMoney(in_coin);

            } else if (input == 2) { // 飲み物の購入
                System.out.print("購入する飲み物の番号を指定してください > ");
                by_drink = scan.nextInt();
                m.buyDrink(by_drink);

            } else if (input == 3) { // お釣りの返却
                m.returnMoney();

            } else if (input == 4) { // 終了
                break top;
            }
        }
    }
}
