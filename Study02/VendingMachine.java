public class VendingMachine {
    private Drink[] drinks = new Drink[6]; // 0番を使わない
    private int[] stock_num = new int[6]; // 同じインデックス位置のものがペアであるものとする
    private int now_money = 0;

    public void registDrink(int index, Drink drink, int stock) {
        // 自動販売機の index 番号に drink を stock 個登録する．
        // index 番号に飲み物が未登録の場合，drink を登録して登録内容を出力する．
        // index 番号に登録済みの場合，既に飲み物が登録されていることを出力する
        if (this.drinks[index] == null) {
            this.drinks[index] = drink;
            this.stock_num[index] = stock;
            System.out.println(index + " 番に「" + drink.getName() + "」を " + stock + " 個登録しました");
        } else {
            System.out.println(index + " 番にはすでに飲み物が登録されています");
        }
    }

    public void insertMoney(int money) {
        // お金をmoney分投入し、現在投入されている金額を出力する。
        this.now_money += money;
        System.out.println(money + " 円を投入しました");
        System.out.println("現在 " + this.now_money + " 円入っています");
    }

    public void buyDrink(int index) {
        // 自動販売機の index 番に登録されている飲み物を購入する．
        // 以下の場合は購入に失敗する;
        // index 番に飲み物が登録されていない場合&お金が足りない場合&在庫がない場合．購入に失敗した場合は購入に失敗したことと購入できない理由を出力する．
        // 購入に成功した場合，お金をその飲み物の値段分だけ減らし，在庫を 1 減らす．
        // 飲み物の購入に成功したことを出力する.
        if (this.drinks[index] == null) {
            System.out.print("購入できませんでした");
            System.out.println("(" + index + "番には飲み物が登録されていません)");

        } else if (stock_num[index] == 0) {
            System.out.print("購入できませんでした");
            System.out.println("(売り切れています)");

        } else if (this.drinks[index].getPrice() > this.now_money) {
            System.out.print("購入できませんでした");
            System.out.println("(お金が足りません)");

        } else {
            this.now_money -= this.drinks[index].getPrice();
            this.stock_num[index] -= 1;

            System.out.println(index + " 番の「" + this.drinks[index].getName() + "」を購入しました");
        }
        this.printInfo();
    }

    public void returnMoney() {
        // お釣りをすべて返却し、投入されている金額を0にする。
        // お釣りの金額を出力する。

        this.now_money = 0;
        System.out.println(this.now_money + " 円のお釣りを出力しました");
    }

    public void printInfo() {
        // 自動販売機の各番号に登録されている飲み物の名前、値段を出力する。
        // 在庫がない飲みものは右端に売り切りの文字を出力する。
        // 現在入っているお金を出力する
        System.out.println();
        System.out.println("=======================");
        for (int i = 1; i < this.drinks.length; i++) { // 0番地を使わないため大なりのみ
            if (this.drinks[i] == null) {
                System.out.println(i + " 番 ----- 未登録 -----");
            } else {
                System.out.print(i + " 番 " + this.drinks[i].getName() + " " + this.drinks[i].getPrice() + " 円 ");
                if (this.stock_num[i] == 0) {
                    System.out.println("売切");
                } else {
                    System.out.println(this.stock_num[i] + " 個");
                }

            }
        }
        System.out.println("=======================");
        System.out.println("現在 " + this.now_money + " 円入っています");
    }
}
