public class Lesson12_3{
    public static void main(String [] args){
        Hero hero = new Hero("hero", 120, 10);

        Monster monster [] = new Monster[2];
        monster[0] = new Slime("slime 1", 12, 10);
        monster[1] = new Goblin("goblin 1", 30, 20);

        System.out.println("==========  Battle Start ==========");
    	hero.attack(monster[0]); // 今回は問題の都合により先頭のモンスターmonster[0]へ攻撃！
        monster[0].attack(hero); // slime 1 が Hero へ攻撃！
        monster[1].attack(hero); // goblin 1 が Hero へ攻撃！
        System.out.println("===================================");
    }
}