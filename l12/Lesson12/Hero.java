public class Hero extends Human {

    Hero(String name, int hp, int atk) {
        super(name, hp, atk);
    }

    // Add here (Lesson12_2)
    public void check(Checkable ch) {
        ch.beChecked();
    }

    // Add here (Lesson12_4)
    public void encount(Character ch) {
        if (ch instanceof Human) {
            Human man = (Human) ch;
            man.talk();
        } else if (ch instanceof Monster) {
            Monster monster = (Monster) ch;
            monster.battleStart();
        }
    }
}