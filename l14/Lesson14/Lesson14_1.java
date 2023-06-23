class Lesson14_1 {
    final static String[] RESULTS_STRING = { "引分", "勝ち", "負け" };

    // 0:グー (Rock), 1:チョキ (Scissors), 2:パー (Paper)
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        Player p1 = new Player(new RandomStrategy());
        Player p2 = new Player(new RockStrategy());
        final int REP = 10000;
        int[] results = { 0, 0, 0 };
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                p2.setStrategy(new PaperStrategy());
            } else if (i == 2) {
                p2.setStrategy(new ScissorsStrategy());
            }
            for (int ri = 0; ri < REP; ri++) {
                final int fHand = p1.selectHand();
                final int sHand = p2.selectHand();
                if (fHand == sHand)
                    results[0]++;
                else if (fHand - sHand == 2 || fHand - sHand == -1)
                    results[1]++;
                else if (fHand - sHand == 1 || fHand - sHand == -2)
                    results[2]++;
                // results[(sHand + 3 - fHand) % 3]++;
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(RESULTS_STRING[i] + ": " + results[i]);
        }
    }
}
