import java.util.Random;

public class Human3 extends Animal2 {
    private int item;

    public Human3(String name, int hp, int power, int defense, int agility, int item) {
        super(name, hp, power, defense, agility);
        this.item = item;
    }

    public int attack() {
        double damage_multtiplier = 1.0;
        if (this.item > new Random().nextInt(100)) {
            System.out.println(this.get_name() + "は道具を使った！ 攻撃力1.4倍！！");
            damage_multtiplier = 1.4;
        }
        super.attack();
        return (int) (this.get_power() * damage_multtiplier);
    }

    public void printStatus() {
        super.printStatus();
        System.out.println("道具使用率 : " + this.item);
    }
}
