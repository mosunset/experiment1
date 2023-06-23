import java.util.Random;

public class Animal1 { // このクラスだけメッソドを定義しない
    private String name;
    private int hp;
    private int power;
    private int agility;

    private int max_hp;

    public Animal1(String name, int hp, int power, int agility) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.agility = agility;

        this.max_hp = hp;
    }

    String get_name() {
        return this.name;
    }

    int get_power() {
        return this.power;
    }

    public int attack() {
        System.out.println(this.name + "の攻撃");
        return power;
    }

    public void defend(int damage) {
        if (this.agility > new Random().nextInt(100)) {
            System.out.println("しかし、" + this.name + "は回避した！");
        } else {
            this.hp -= damage;
            if (this.hp <= 0) {
                this.hp = 0;
            }
            System.out.println(this.name + "に" + damage + "のダメージ！(" + this.hp + " / " + this.max_hp + ")");
            if (this.hp == 0) {
                System.out.println(this.name + "は倒れた...");
                new Study03_3().set_turn(false);
            }
        }
    }

    public void printStatus() {
        System.out.println("--- " + this.name + " ---");
        System.out.println("HP : " + this.hp);
        System.out.println("攻撃力 : " + this.power);
        System.out.println("回避率 : " + this.agility);
    }
}
