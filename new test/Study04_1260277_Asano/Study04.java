import java.util.Scanner;

public class Study04 {
    private static boolean turn_exit = true;

    public void set_turn() {
        turn_exit = false;
    }

    public static void main(String[] args) {

        Ally[] allys = new Ally[4]; // 仲間の配列
        allys[0] = new Hero("勇者", 100, 25);
        allys[1] = new Knight("騎士", 150, 20);
        allys[2] = new Monk("僧侶", 80, 5);
        allys[3] = new Wizard("魔術師", 80, 10);

        Satan satan = new Satan("魔王", 200, 30);

        // 仲間
        Ally[] party = new Ally[2];
        party[0] = allys[0];

        // 勇者と仲間全てのステータスを出力する．
        System.out.println("-----");
        for (Ally ally : allys) {
            ally.showStatus();
        }
        System.out.println("-----");

        // 連れて行く仲間の ID を標準入力で受け取り，その仲間をパーティに入れ，現在のパーティを表示する．（ID は味方（Ally）のみが持つ）
        int input = 0;
        selectparty: while (true) {
            System.out.println("連れて行く仲間を選んでください（IDを入力）");
            System.out.print("ID: ");
            try {
                input = new Scanner(System.in).nextInt();// 配列の範囲合わせ
                if (1 <= input && input <= 3) {
                    party[1] = allys[input];
                    System.out.println(party[1].get_name() + "が仲間になった!");
                    break selectparty;
                } else {
                    System.out.println("Error : 1〜3を入力してください");
                }
            } catch (Exception e) {
                System.out.println("Error : 1〜3を入力してください");
            } finally {
                System.out.println();
            }
        }

        // パーティーのステータスを出力する
        System.out.println("現在のパーティー");
        System.out.println("-----");
        party[0].showStatus();
        party[1].showStatus();
        System.out.println("-----\n");

        // satanのステータス
        System.out.println(satan.get_name() + "が現れた!");
        satan.showStatus();

        // バトルスタート
        int turn = 0;
        System.out.println("\n========== BATTLE START ==========");
        top: while (turn_exit) {
            turn++;
            System.out.println("ターン: " + turn);
            // 仲間、勇者、魔王の順に行動する
            // 仲間は奇数ターンで通常攻撃、偶数ターンでスキルを仕様
            // 魔王は偶数ターンにおいて全体攻撃，それ以外では通常攻撃を行う．全体攻撃の場合，パーティ全員に攻撃力分のダメージを与える．
            // （仲間 HP が0の場合は，偶数ターンであっても通常攻撃を行う．）
            // 勇者と魔王どちらかの HP が 0 になった場合，その時点で結果を出力し戦闘を終了する（体力がマイナスにならないよう実装すること）．
            // 仲間の HP が 0 になった場合は仲間はその後行動できず，スキルに関する出力は一切行わない．戦闘は勇者と魔王のみで続行する．
            if (turn % 2 == 1) {// 奇数 通常攻撃
                if (party[1].get_hp() != 0) {
                    party[1].attack(satan);
                }
                party[0].attack(satan);
                System.out.println();
                if (!turn_exit) { // falseの場合 勇者勝ち
                    System.out.println(">> " + satan.get_name() + "は倒れた!");
                    System.out.println("---------- YOU WIN ----------");
                    break top;
                }

                satan.attack(party[0]);
                System.out.println();
                if (!turn_exit) { // falseの場合 勇者負け
                    System.out.println(">> " + allys[0].get_name() + "は倒れた!");
                    System.out.println("---------- YOU LOSE ----------");
                    break top;
                }

            } else {// 偶数 スキル＆全体攻撃
                if (party[1].get_hp() != 0) {
                    if (party[1] instanceof Knight) {
                        Knight knight = (Knight) party[1];
                        knight.skill(satan);
                    } else if (party[1] instanceof Monk) {
                        Monk monk = (Monk) party[1];
                        monk.skill(party[0]);
                    } else if (party[1] instanceof Wizard) {
                        Wizard wizard = (Wizard) party[1];
                        wizard.skill(party[0]);
                    }
                }

                party[0].attack(satan);
                System.out.println();
                if (!turn_exit) { // falseの場合 勇者勝ち
                    System.out.println(">> " + satan.get_name() + "は倒れた!");
                    System.out.println("---------- YOU WIN ----------");
                    break top;
                }

                if (party[1].get_hp() == 0) {
                    satan.attack(party[0]);
                } else {
                    satan.satanAttack(party);
                }
                System.out.println();

                if (!turn_exit) { // falseの場合 勇者負け
                    System.out.println(">> " + allys[0].get_name() + "は倒れた!");
                    System.out.println("---------- YOU LOSE ----------");
                    break top;
                }

                party[0].resetStatus();
            }

        }

    }

}