public abstract class Monster {
    // -------フィールド-------
    // add here
    private int hp, level;
    private String name, type;

    // -------コンストラクタ-------
    // add here

    public Monster(String name, int hp, int level,String type) {
        this.name = name;
        this.hp = hp;
        this.level = level;
        this.type = type;
    }


    // -------メソッド-------
    // add here
    public int getHp() {
        return this.hp;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void showStatus() {
        System.out.println("Name:" + this.getName());
        System.out.println("Type:" + this.getType());
        System.out.println("Level:" + this.getLevel());
        System.out.println("HP:" + this.getHp());
    }

    public void encountMonster() {
        System.out.println(this.getName() + "が現れた！");
    }

    public abstract void action();
}
