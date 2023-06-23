public class Lesson11_4 {
    public static void main(String[] args) {
        Slime slime = new Slime("メタルスライム", 100, 14);
        Dragon dragon = new Dragon("ブラックドラゴン", 300, 30, 25);
        slime.encountMonster();
        slime.showStatus();
        dragon.encountMonster();
        dragon.showStatus();
        dragon.action();
        slime.action();
    }
}
