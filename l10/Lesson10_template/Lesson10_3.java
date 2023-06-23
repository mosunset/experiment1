public class Lesson10_3 {
	public static void main(String[] args) {
		Player hero = new Player(20, 100, "勇者", 120);
		Player villager = new Player(10, 50, "戦士");
		Enemy enemy1 = new Enemy(40, 20, "スライム");
		Enemy enemy2 = new Enemy(50, 30, "ゴーレム");
		Character[] enemy = {enemy1, enemy2};

		System.out.println("-----");
		hero.printStatus();
		villager.printStatus();
		enemy1.printStatus();
		enemy2.printStatus();

		enemy1.attack(hero);
		hero.attack(enemy1);
		enemy2.attack(villager);
		villager.attack(enemy2);

		System.out.println("-----");
		hero.printStatus();
		villager.printStatus();
		enemy1.printStatus();
		enemy2.printStatus();
	}
}