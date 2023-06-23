public class Player extends Character {
    protected int def;

    public Player() {
        super();
        this.def = 0;
    }

    // add here(lesson10_1)
    public Player(int atk, int hp, String name) {
        super(atk, hp, name);
        this.def = 0;
    }

    public Player(int atk, int hp, String name, int def) {
        super(atk, hp, name);
        this.def = def;
    }

    // add here(lesson10_2)
    public void printStatus() {
        if (this.hp != 0) {
            super.printStatus();
            System.out.println("DEF：" + this.def);
            System.out.println("-----");
        }
    }

    public void attack(Enemy e) {
        if (e.hp > 0 && this.hp > 0) {
            System.out.println(this.name + "から" + e.name + "への攻撃！");
            e.damage(this.atk);
        }
    }

    // add here(lesson10_3)
    public void damage(int atk) {
        if (def > 100) {
            System.out.println(this.name + "に 0 ダメージ (現在の HP : " + this.hp + ")");
        } else {
            this.hp -= atk * (100 - this.def) / 100;
            if (this.hp <= 0) {
                this.hp = 0;
            }
            System.out.println(this.name + "に" + atk * (100 - this.def) / 100 + "ダメージ（現在のHP : " + this.hp + "）");
            if (this.hp <= 0) {
                System.out.println(this.name + "は倒れた");
            }
        }
    }

    // add here(lesson10_4)
    public void attackToAll(Enemy[] e) {
        System.out.println(this.name + "の全体攻撃！");
        for (int i = 0; i < e.length; i++) {
            e[i].hp -= this.atk / 2;
            if (e[i].hp <= 0) {
                e[i].hp = 0;
            }
            System.out.println(e[i].name + "に" + this.atk / 2 + "ダメージ（現在のHP : " + e[i].hp + "）");
            if (e[i].hp <= 0) {
                System.out.println(e[i].name + "は倒れた");
            }
        }
    }

}