public class Satan extends Character {
    public Satan(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    public void satanAttack(Ally[] party) {
        // partyに格納されたキャラクター全員に攻撃する
        System.out.println(">> " + super.get_name() + "の全体攻撃!");
        for (Ally ally : party) {
            ally.damage(super.get_atk());
        }
    }
}
