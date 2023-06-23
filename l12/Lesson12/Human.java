public class Human extends Character {

    public Human(String name, int hp, int atk){
        super(name, hp, atk);
    }

    protected void showStatus(){
        System.out.println("[ " + this.name + " ]");
        System.out.println("HP : " + this.hp);
        System.out.println("ATK : " + this.atk);
    }

    public void attack(Monster monster){
        System.out.println(this.name + "の攻撃！");
        monster.damage(this.atk);
    }

    public void talk(){
        System.out.println(this.name + " : お疲れさまです");
    }
}