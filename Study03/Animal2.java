import java.util.Random;

public class Animal2 { // このクラスだけメッソドを定義しない
    private String name;
    private int hp;
    private int power;
    private int defense;
    private int agility;

    private int max_hp;

    public Animal2(String name, int hp, int power, int defense, int agility) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.defense = defense;
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
            int temp_damage = 0;
            if (damage <= this.defense) {
                temp_damage = 1;
                this.hp -= 1;

            } else if (damage > this.defense) {
                temp_damage = damage - this.defense;
                this.hp -= temp_damage;
            }
            if (this.hp <= 0) {
                this.hp = 0;
            }
            System.out.println(
                    this.name + "に" + temp_damage + "のダメージ！(" + this.hp + " / " + this.max_hp + ")");
            if (this.hp == 0) {
                System.out.println(this.name + "は倒れた...");
                new Study03_3().set_turn(false);
            }
        }
    }

    public void set_suddendeath() {
        this.hp /= 2;
        this.power *= 2;
    }

    public void printStatus() {
        System.out.println("--- " + this.name + " ---");
        System.out.println("HP : " + this.hp);
        System.out.println("攻撃力 : " + this.power);
        System.out.println("回避率 : " + this.agility);
    }
}
