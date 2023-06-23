public abstract class Character {
    protected int hp;
    protected int atk;
    protected String name;

    public Character(String name, int hp, int atk){
        this.name = name;
        this.hp = hp;
        this.atk = atk;
    }

    abstract void showStatus();

    public void damage(double atk){
        if(atk >= this.hp){
            System.out.println("\t" + this.name + "へ" + (int)atk + "のダメージ！");
            this.hp = 0;
            System.out.println("\t" + this.name + "は力尽きた");
        }else{
            System.out.println("\t" + this.name + "へ" + (int)atk + "のダメージ！");
            this.hp -= (int)atk;
            System.out.println("\t" + this.name + "の残りHP : " + this.hp);
        }
    }

    public static char[] get_name() {
        return null;
    }
}