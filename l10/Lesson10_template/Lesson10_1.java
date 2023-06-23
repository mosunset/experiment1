public class Lesson10_1 {
    public static void main(String[] args) {
        Player hero = new Player(5, 100, "勇者");
        Player warrior = new Player(10, 50, "戦士", 20);

        System.out.println("-----");
        hero.printStatus();
        warrior.printStatus();
        System.out.println("-----");
    }
}