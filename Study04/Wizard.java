public class Wizard extends Ally implements Member {
    public Wizard(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    public void skill(Character c) {
        // 勇者の攻撃力を3倍する
        // ターン終了時に攻撃力を初期の値に戻す（Ally.java）
        System.out.println(">> " + this.get_name() + "がスキルを発動!");
        c.set_atk(c.get_atk() * 3);
        System.out.println(">> "+this.get_name()+"が" + c.get_name() + "の攻撃力を3倍にした!");
    }
}
