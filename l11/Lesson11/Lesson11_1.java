public class Lesson11_1 {
    public static void main(String[] args) {
        Hero hero = new Hero("勇者A", 100, 14);
        Enemy enemy = new Enemy("スライムA", 50, 7);
        hero.printName();
        enemy.printName();
        hero.attack(enemy);
    }
}
