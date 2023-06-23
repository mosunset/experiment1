public class Study03_3 { // 継承を使用して作成
    private static int turn = 0;
    private static boolean turn_next = true;

    public static void main(String[] args) {
        Human3 man = new Human3("工科大介", 100, 10, 10, 10, 50);
        Parrot3 rot = new Parrot3("シロッコくん", 30, 30, 10, 40, 25);

        man.printStatus();
        rot.printStatus();
        top: while (true) {
            turn += 1;
            if (turn == 1) {
                System.out.println();
            }
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
            if (turn == 4) {
                System.out.println();
                System.out.println("*** サドンデス ***");
                man.set_suddendeath();
                rot.set_suddendeath();
                man.printStatus();
                rot.printStatus();
                System.out.println("******************");
                System.out.println();
            }
        }
    }

    void set_turn(boolean set) {
        turn_next = set;
    }

}