public class Slime extends Monster implements Cloneable {
    // -------フィールド-------

    // -------コンストラクタ-------
    public Slime(String name, int hp, int level) {
        super(name, hp, level, "Slime");
    }

    // -------メソッド-------

    public void action() {
        System.out.println(this.getName() + "は逃げようとしている");
    }

    public Slime clone(String name) {
        System.out.println(this.getName() + "が分裂し、" + name + "が誕生した！");
        return new Slime(name, getHp(), getLevel());
    }
}
