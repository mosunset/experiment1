public class Goblin extends Monster {

    public Goblin(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    // Add here (Lesson13_3)
    public void attack(Human human) {
        System.out.println(this.name + "はナイフで斬りつけた！");
        human.damage(this.atk * 1.5);
    }
}