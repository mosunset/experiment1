public class Lesson12_1 {
    public static void main(String[] args) {
        Human[] h = new Human[3];
        h[0] = new Hero("hero", 150, 40);
        h[1] = new Wizard("wizard", 100, 20);
        h[2] = new Priest("priest", 110, 18);

        System.out.println("==== Status ====");
        for (Human n : h) {
            n.showStatus();
        }

        System.out.println("=================");
    }
}