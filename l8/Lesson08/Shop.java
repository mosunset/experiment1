//Use Lesson08_4
public class Shop {
    int proceed = 0;

    // Add here***************************************************
    public void sell(Customer c, Snack s) {
        if (c.money >= s.price) {
            c.money -= s.price;
            System.out.print(c.name + "は" + s.name + "（" + s.price + " 円）を購入した");
            System.out.print(" --> ");
            System.out.println(c.name + "の所持金が" + c.money + "円になった");
            this.proceed += s.price;
            System.out.println("現在の売上金 : " + this.proceed + " 円");
        } else {
            System.out.print(c.name + "は" + s.name + "（" + s.price + " 円）を購入できなかった");
            System.out.println("（所持金 " + c.money + " 円）");
        }
    }
}