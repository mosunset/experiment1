import java.util.Random;

public class Human1 { // 継承を使用せず作成
    // フィールド （追加しても良い）
    private String name;
    private int hp;
    private int power;
    private int agility;
    private int item;

    private int max_hp;

    Study03_1 study = new Study03_1();

    // コンストラクタ
    public Human1(String name, int hp, int power, int agility, int item) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.agility = agility;
        this.item = item;

        this.max_hp = hp;
    }

    // getter & setter （必要に応じて）

    // メソッド （追加しても良い）
    public int randomInt() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    public int attack() {
        // 条件； 0 から 99 の範囲で乱数を生成し，生成した乱数が道具使用率未満の場合，
        // １； Human1 が道具を使用し攻撃力が 1.4 倍になったことを出力し，
        // ２； さらに Human1 による攻撃であることを出力する．
        // 条件３；その後，自身の power を 1 ターンだけ 1.4 倍 (小数点以下切り捨て)してダメージ値として返す．
        // 条件； 生成した乱数が道具使用率以上の場合，
        // ４； Human1 による攻撃であることを出力し，power をダメージ値として返す

        double damage_multtiplier = 1.0;
        System.out.println();
        if (this.item > randomInt()) {
            System.out.println(this.name + "は道具を使った！ 攻撃力1.4倍！！");
            damage_multtiplier = 1.4;
        }
        System.out.println(this.name + "の攻撃！");
        return (int) (this.power * damage_multtiplier);
    }

    public void defend(int damage) {
        // 0 から 99 の範囲で乱数を生成し，
        // 条件１；生成した乱数が回避率未満なら回避した旨を出力して終了，
        // 条件２；そうでないならば引数の damageの値だけ hp を減らし，ダメージを受けた旨を出力する
        if (this.agility > randomInt()) {
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
        // Human1の現在のステータスを出力する。
        System.out.println("--- " + this.name + " ---");
        System.out.println("HP : " + this.hp);
        System.out.println("攻撃力 : " + this.power);
        System.out.println("回避率 : " + this.agility);
        System.out.println("道具使用率 : " + this.item);
    }

}
