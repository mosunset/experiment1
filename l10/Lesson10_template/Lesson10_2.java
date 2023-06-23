public class Lesson10_2 {
    public static void main(String[] args) {
        Player hero = new Player(5, 100, "勇者", 10);
        Player warrior = new Player(10, 50, "戦士");

        System.out.println("-----");
        hero.printStatus();
        warrior.printStatus();
    }
}