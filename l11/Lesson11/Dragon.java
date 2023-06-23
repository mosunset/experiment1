public class Dragon extends Monster {
    // -------フィールド-------
    private int mp;

    // -------コンストラクタ-------
    public Dragon(String name, int hp, int level, int mp) {
        super(name, hp, level, "Dragon");
        this.mp = mp;
    }

    // -------メソッド-------

    public void showStatus() {
        super.showStatus();
        System.out.println("MP:" + this.mp);
    }

    public void action() {
        System.out.println(this.getName() + "は威圧している");
    }

}
