public class Lesson11_2 {
    public static void main(String[] args) {
        Hero hero = new Hero("勇者B", 110, 16);
        Enemy enemy = new Enemy("スライムB", 45, 5);
        hero.printName();
        hero.showStatus();
        enemy.printName();
        enemy.showStatus();
        hero.attack(enemy);
    }
}
