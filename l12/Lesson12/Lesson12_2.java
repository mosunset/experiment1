public class Lesson12_2 {
    public static void main(String[] args) {

        Hero hero = new Hero("hero", 150, 40);
        Checkable ch1 = new Pot("100G");
        Checkable ch2 = new Closet("薬草");

        hero.check(ch1);
        hero.check(ch2);
    }
}