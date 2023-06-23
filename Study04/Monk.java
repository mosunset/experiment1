public class Monk extends Ally implements Member {
    public Monk(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    public void skill(Character c) {
        // 勇者を 20 回復させる．（最大 HP は超えない）
        System.out.println(">> " + this.get_name() + "がスキルを発動!");
        c.set_heel_hp(20);
        System.out.println(">> " + c.get_name() + "の体力を回復した!");
        System.out.println(c.get_name() + "の残りHP: " + c.get_hp());
    }
}
