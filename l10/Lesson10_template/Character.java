public class Character {
    protected int atk;
    protected int hp;
    protected String name;

    public Character() {
        this.atk = 5;
        this.hp = 20;
        this.name = null;
    }

    public Character(int atk, int hp, String name) {
        this.atk = atk;
        this.hp = hp;
        this.name = name;
    }

    public void attack(Character c) {

    }

    public void damage(int atk) {
        this.hp -= atk;
        if (this.hp <= 0) {
            this.hp = 0;
        }
        System.out.println(this.name + "に" + atk + "ダメージ（現在のHP：" + this.hp + "）");
        if (this.hp <= 0) {
            System.out.println(this.name + "は倒れた");
        }
    }

    public void run() {
        System.out.println(this.name + "は逃げ出した");
    }

    public void printStatus() {
        System.out.println(this.name + "のステータス");
        System.out.println("HP：" + this.hp);
        System.out.println("ATK：" + this.atk);
    }
}