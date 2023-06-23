public class Lesson12_4{
    public static void main(String [] args){
        Hero hero = new Hero("hero", 150, 10);

        System.out.println("========= encount =========");
        Human villager = new Villager("Villager 1", 10, 1);

        hero.encount(villager); // 人間(Human)とエンカウント
        System.out.println();

        System.out.println("========= encount =========");
        Monster monster = new Slime("slime 1", 10, 2);
        hero.encount(monster); // モンスター(Monster)とエンカウント
    }
}