public class Main {
    public static void main(String[] args) {
        // （以下の内容をJavaで記述いていく）
        // 勇者よ、この仮想世界に生まれよ！
        // おばけきのこよ、この仮想世界に生まれよ！
        // 勇者よ、戦え！
        // おばけきのこよ、逃げろ！

        Hero h = new Hero();
        h.name = "ミナト";
        h.hp = 100;
        System.out.println("勇者" + h.name + "を生み出しました！");

        Matango m1 = new Matango();
        m1.hp = 50;
        m1.suffix = 'A';

        Matango m2 = new Matango();
        m2.hp = 48;
        m2.suffix = 'B';

        h.sit(5);
        h.slip();
        m1.run();
        h.sit(25);
        m2.run();
        h.run();
    }
}

class Hero {
    String name;
    int hp;

    public void attack() {
    }

    public void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は、眠って回復した！");
    }

    public void sit(int sec) {
        this.hp += sec;
        System.out.println(this.name + "は、" + sec + "秒座った！");
        System.out.println("HPが" + sec + "ポイント回復した");
    }

    public void slip() {
        this.hp -= 5;
        System.out.println(this.name + "は、転んだ！");
        System.out.println("5のダメージ！");
    }

    public void run() {
        System.out.println(this.name + "は、逃げ出した！");
        System.out.println("GAMEOVER");
        System.out.println("最終HPは" + this.hp + "でした");
    }
}

class Matango {
    int hp;
    final int level = 10;
    char suffix;
    public void run(){
        System.out.println("おばけきのこ"+this.suffix+"は逃げ出した！");
    }
}

