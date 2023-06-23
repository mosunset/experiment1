public class Ally extends Character {
    private int id;

    public Ally(String name, int hp, int atk) {
        super(name, hp, atk);
        switch (name) {
            case "勇者":
                this.id = 0;
                break;
            case "騎士":
                this.id = 1;
                break;
            case "僧侶":
                this.id = 2;
                break;
            case "魔術師":
                this.id = 3;
                break;
            default:
                break;
        }
    }

    public void showStatus() {
        // ステータスと ID を出力する．
        super.showStatus();
        System.out.println(super.get_name() + "のID: " + this.id);

    }

    public void resetStatus() {
        // 上昇した攻撃力をもとに戻す.
        super.set_atk(super.get_default_atk());
    }

}
