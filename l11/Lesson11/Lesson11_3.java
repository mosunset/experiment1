public class Lesson11_3 {
	public static void main(String[] args) {
		Hero hero=new Hero("勇者C",120,18);
		Enemy enemy=new Enemy("スライムC",60,6);
		hero.printName();
		hero.showStatus();
		enemy.printName();
		enemy.showStatus();
		hero.criticalAttack(enemy);
	}
}
