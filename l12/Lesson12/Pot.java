public class Pot implements Checkable {
    String item;

    public Pot(String item) {
        this.item = item;
    }

    public void beChecked() {
        System.out.println("壺を壊した！");
        System.out.println(this.item + "を手に入れた！");
    }
}