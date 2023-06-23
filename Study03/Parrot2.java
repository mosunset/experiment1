import java.util.Random;

public class Parrot2 extends Animal1 {
    private int fly;

    public Parrot2(String name, int hp, int power, int agility, int fly) {
        super(name, hp, power, agility);
        this.fly = fly;
    }

    public void defend(int damage) {
        if (this.fly > new Random().nextInt(100)) {
            System.out.println("しかし、" + this.get_name() + "は空を飛んで回避した！");
        } else {
            super.defend(damage);
        }
    }

    public void printStatus() {
        super.printStatus();
        System.out.println("飛行率 : " + this.fly);
    }
}
