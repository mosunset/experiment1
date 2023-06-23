public class Character {
    private String name;
    private int hp;
    private int atk;

    private int max_hp;
    private int default_atk;

    public Character(String name, int hp, int atk) {
        // 名前，体力，攻撃力を設定するコンストラクタ．
        this.name = name;
        this.hp = hp;
        this.atk = atk;

        this.max_hp = hp;
        this.default_atk = atk;
    }

    public String get_name() {
        return this.name;
    }

    public int get_atk() {
        return this.atk;
    }

    public void set_atk(int atk) {
        this.atk = atk;
    }

    public int get_hp() {
        return this.hp;
    }

    public void set_heel_hp(int hp) {
        this.hp += hp;
        if (this.max_hp <= this.hp) {
            this.hp = this.max_hp;
        }
    }

    public int get_default_atk() {
        return this.default_atk;
    }

    public void damage(int atk) {
        // atk 分の値のダメージを受ける処理を行う
        System.out.println(this.name + "に" + atk + "ダメージ");
        this.hp -= atk;
        if (this.hp <= 0) {
            this.hp = 0;

        }
        System.out.println(this.name + "の残り HP: " + this.hp);
        if (this.hp == 0 && (this instanceof Hero || this instanceof Satan)) {
            Study04 s = new Study04();
            s.set_turn();
        }
    }

    public void attack(Character c) {
        // 指定されたキャラクターに攻撃する．
        System.out.print(">> " + this.name + "の攻撃! ");
        c.damage(this.atk);
    }

    public void showStatus() {
        // キャラクターのステータスを出力する．
        System.out.println(this.name + "のステータス");
        System.out.println("HP: " + this.hp + ", ATK: " + this.atk);
    }
}
