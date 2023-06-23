public class Lesson10_4 {
    public static void main(String[] args) {
        Player hero = new Player(10, 100, "勇者", 50);
        Enemy enemy1 = new Enemy(4, 15, "スライムA");
        Enemy enemy2 = new Enemy(4, 20, "スライムB", 3);

        System.out.println("-----");
        hero.printStatus();
        enemy1.printStatus();
        enemy2.printStatus();

        hero.attack(enemy1);
        enemy1.attack(hero);
        enemy2.attack(hero);

        // add here(Lesson10_4)
        Enemy[] e = new Enemy[] { enemy1, enemy2 };
        hero.attackToAll(e);

        // ここまで

        System.out.println("-----");
        hero.printStatus();
        enemy1.printStatus();
        enemy2.printStatus();
    }
}