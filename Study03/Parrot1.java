import java.util.Random;

public class Parrot1 { // 継承を使用せず作成
    private String name;
    private int hp;
    private int power;
    private int agility;
    private int fly;

    private int max_hp;

    Study03_1 study = new Study03_1();

    public Parrot1(String name, int hp, int power, int agility, int fly) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.agility = agility;
        this.fly = fly;

        this.max_hp = hp;
    }

    public int randomInt() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    public int attack() {
        // Parrot1 による攻撃であることを出力し，power をダメージ値として返す
        System.out.println();
        System.out.println(this.name + "の攻撃！");
        return power;
    }

    public void defend(int damage) {
        // 0 から 99 までの範囲で乱数を生成し，
        // 生成した乱数が飛行率未満なら空を飛んで回避した旨を出力して終了する．
        // 飛行率以上の場合は，新たに 0 から 99 までの範囲で乱数を生成し，
        // 生成した乱数が回避率未満なら回避した旨を出力し終了，
        // そうでないならば引数の damage の値だけ hp を減らし，
        // ダメージを受けた旨を出力する
        if (this.fly > randomInt()) {
            System.out.println("しかし、" + this.name + "は空を飛んで回避した！");
        } else if (this.agility > randomInt()) {
            System.out.println("しかし、" + this.name + "は回避した！");
        } else {
            this.hp -= damage;
            if (this.hp <= 0) {
                this.hp = 0;
            }
            System.out.println(this.name + "に" + damage + "のダメージ！(" + this.hp + " / " + this.max_hp + ")");
            if (this.hp == 0) {
                System.out.println(this.name + "は倒れた...");
                study.set_turn(false);
            }
        }
    }

    public void printStatus() {
        // Parrot1の現在のステータスを出力する。
        System.out.println("--- " + this.name + " ---");
        System.out.println("HP : " + this.hp);
        System.out.println("攻撃力 : " + this.power);
        System.out.println("回避率 : " + this.agility);
        System.out.println("飛行率 : " + this.fly);
    }
}
