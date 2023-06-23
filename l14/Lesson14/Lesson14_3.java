class Lesson14_3 {
    final static String[] RESULTS_STRING = { "引分", "勝ち", "負け" };

    // 0:グー (Rock), 1:チョキ (Scissors), 2:パー (Paper)
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("usage: java Lesson14_3 1st 2nd-1 2nd-2 2nd-3");
            System.out.println("  player: Rock, Paper, Scissors, Random");
            return;
        }
        try {
            // add here
            Player p1 = new Player(StrategyFactory.createStrategy(args[0]));
            Player p2 = new Player(StrategyFactory.createStrategy(args[1]));

            final int REP = 10000;
            int[] results = { 0, 0, 0 };
            for (int i = 0; i < 3; i++) {
                if (i == 1) {
                    // add here
                    p2.setStrategy(StrategyFactory.createStrategy(args[2]));

                } else if (i == 2) {
                    // add here
                    p2.setStrategy(StrategyFactory.createStrategy(args[3]));

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
                    // results[(sHand + 3 - sHand) % 3]++;
                }
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(RESULTS_STRING[i] + ": " + results[i]);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
