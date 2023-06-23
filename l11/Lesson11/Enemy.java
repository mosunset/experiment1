public class Enemy extends Character {
    // -------コンストラクタ-------
    // add here
    public Enemy(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    // -------メソッド-------
    // add here
    public void attack(Hero hero) {
        System.out.println(this.getName() + "の攻撃！");
        hero.takeDamage(this.getAtk());
        System.out.println(this.getName() + "は" + hero.getName() + "に" + this.getAtk() + "のダメージを与えた！");
        System.out.println(hero.getName() + "の残りHPは" + hero.getHp());
    }

    public void printName() {
        System.out.println("敵のキャラクターは" + super.getName() + "だ！");
    }

}
