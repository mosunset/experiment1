public class Knight extends Ally implements Member {
    public Knight(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    public void skill(Character c) {
        // 2倍の攻撃力で指定されたキャラクターに攻撃する
        // ターン終了時に攻撃力を初期の値に戻す（Ally.java）
        System.out.println(">> " + super.get_name() + "がスキルを発動!");
        super.set_atk(super.get_atk() * 2);
        System.out.println(">> " + super.get_name() + "の攻撃力: " + super.get_atk());
        super.attack(c);
        super.resetStatus();
    }
}
