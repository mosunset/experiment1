package l8;

public class Main {
    public static void main(String[] args) {
        Sword s = new Sword();
        s.name = "炎の剣";
        s.damage = 10;
        Hero h = new Hero("ミナト");
        h.hp = 100;
        h.sword = s;
        System.out.println("現在の武器は" + h.sword.name);
        Hero h1 = new Hero();
        System.out.println(h1.name);

    }
}

class Sword {
    String name;
    int damage;
}

class Hero {
    String name;
    int hp;
    Sword sword;

    public void attack() {
        System.out.println(this.name + "は攻撃した！");
        System.out.println("敵二５ポイントのダメージを与えた！");
    }

    public Hero(String name) {
        this.hp = 100;
        this.name = name;
    }

    public Hero() {
        this("ダミー");
    }
}

class Wizard {
    String name;
    int hp;

    public void heal(Hero h) {
        h.hp += 10;
        System.out.println(h.name + "のHPを10回復した");
    }
}