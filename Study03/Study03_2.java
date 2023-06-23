public class Study03_2 { // 継承を使用して作成
    private static int turn = 0;
    private static boolean turn_next = true;

    public static void main(String[] args) {
        Human2 man = new Human2("工科大介", 100, 10, 10, 50);
        Parrot2 rot = new Parrot2("シロッコくん", 30, 30, 40, 25);

        man.printStatus();
        rot.printStatus();
        top: while (true) {
            turn += 1;
            System.out.println("-------- ターン" + turn + " --------");
            int man_attack_damage = man.attack();
            rot.defend(man_attack_damage);
            if (!turn_next) {
                break top;
            }

            int rot_attack_damage = rot.attack();
            man.defend(rot_attack_damage);
            if (!turn_next) {
                break top;
            }
        }
    }

    void set_turn(boolean set) {
        turn_next = set;
    }

}