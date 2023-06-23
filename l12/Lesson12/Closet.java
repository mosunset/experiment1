// Add here(Lesson12_2)
public class Closet implements Checkable {
    String item;

    public Closet(String item) {
        this.item = item;
    }

    public void beChecked() {
        System.out.println("クローゼットを開けた！");
        System.out.println(this.item + "を手に入れた！");
    }
}