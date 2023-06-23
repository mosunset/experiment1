public class Lesson10_5 {
	public static void main(String[] args) {
		Player hero = new Player(20, 100, "勇者", 50);
		Boss boss = new Boss(10, 200, "ドラゴン");

		System.out.println("-----");
		hero.printStatus();
		boss.printStatus();

		hero.attack(boss);
		boss.attackHard(hero);

		System.out.println("-----");
		hero.printStatus();
		boss.printStatus();

		hero.attack(boss);
		boss.attackHard(hero);

		System.out.println("-----");
		hero.printStatus();
		boss.printStatus();
	}
}