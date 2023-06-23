public class Lesson11_5 {
    public static void main(String[] args) {
	Slime slime_a = new Slime("スライムA", 100, 14);
	slime_a.encountMonster();
	slime_a.showStatus();
	Slime slime_b = slime_a.clone("スライムB");
	slime_b.showStatus();
    }
}
