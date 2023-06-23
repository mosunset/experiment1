public class Boss extends Enemy {
    public Boss() {
        super();
    }

    // add here(lesson10_5)
    public Boss(int atk, int hp, String name) {
        super(atk, hp, name);
    }

    public void attackHard(Player p) {
        if (this.hp > 0) {
            if (isAttackable && p.hp > 0) {
                System.out.println(this.name + "から" + p.name + "への強攻撃！");

                p.damage(this.atk * 5);
                isAttackable = false;
            } else {
                System.out.println(this.name + "は反動で動けない");
                isAttackable = true;
            }
        }
    }
}