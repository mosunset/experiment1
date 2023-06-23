public class Hero extends Character implements Critical {
    // -------コンストラクタ-------
    // add here
    public Hero(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    // -------メソッド-------
    // add here
    public void attack(Enemy enemy) {
        System.out.println(this.getName() + "の攻撃！");
        enemy.takeDamage(this.getAtk());
        System.out.println(this.getName() + "は" + enemy.getName() + "に" + this.getAtk() + "のダメージを与えた！");
        System.out.println(enemy.getName() + "の残りHPは" + enemy.getHp());

    }

    public void printName() {
        System.out.println("プレイヤーのキャラクターは" + this.getName() + "だ！");
    }


    public int calcCritical() {

        return this.getAtk() * Critical.CRITICAL;
    }

    public void criticalAttack(Enemy enemy) {
        System.out.println(this.getName() + "の攻撃！");
        System.out.println("クリティカルヒット！！");
        int criticaldamage = calcCritical();
        enemy.takeDamage(criticaldamage);
        System.out.println(this.getName() + "は" + enemy.getName() + "に" + criticaldamage + "のダメージを与えた！");
        System.out.println(enemy.getName() + "の残りHPは" + enemy.getHp());
    }
}
