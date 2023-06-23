public class Lesson08_4{
    public static void main(String[] args){

        Customer c1 = new Customer("太郎", 100);
        Customer c2 = new Customer("花子", 120);

        Snack s1 = new Snack("うまい棒", 10);
        Snack s2 = new Snack("グミ", 80);
        Snack s3 = new Snack("アルフォート", 120);

        //Add here*******************************
        Shop shop = new Shop();

        shop.sell(c1,s1);
        shop.sell(c1,s2);
        shop.sell(c2,s1);
        shop.sell(c2,s3);
    }
}