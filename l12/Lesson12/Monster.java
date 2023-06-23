public class Monster extends Character{

    public Monster(String name, int hp, int atk){
        super(name, hp, atk);
    }

    @Override
    public void showStatus(){
        System.out.println("[ " + this.name + " ]");
        System.out.println("HP : " + this.hp);
    }

    public void attack(Human human){
        System.out.println(this.name + "の攻撃！");
        human.damage(this.atk);
    }

    public void battleStart(){
        System.out.println(this.name + " が現れた！");
    }
}