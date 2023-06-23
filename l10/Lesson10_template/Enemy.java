public class Enemy extends Character {
    protected int turn;
    protected boolean isAttackable = true;

    public Enemy() {
        super();
        this.turn = -1;
    }

    public Enemy(int atk, int hp, String name) {
        super(atk, hp, name);
        this.turn = -1;
    }

    public Enemy(int atk, int hp, String name, int turn) {
        super(atk, hp, name);
        this.turn = turn;
    }

    public void attack(Player p) {
        if (this.hp > 0) {
            if (this.isAttackable) {
                if (p.hp > 0) {
                    System.out.println(this.name + "から" + p.name + "への攻撃！");
                    p.damage(this.atk);
                }
            } else {
                this.isAttackable = false;
                System.out.println(this.name + "は反動で動けない!");
            }
            this.turn--;
        }
    }

    public void printStatus() {
        if (this.hp > 0) {
            super.printStatus();
            if (turn >= 0) {
                System.out.println(this.name + "が逃げるまで" + this.turn + "ターン");
                if (turn == 0) {
                    super.run();
                }
            }
            System.out.println("----------");
        }
    }
}