public class Lesson14_2 {
    public static void main(String[] args) {
        try {
            Player player = new Player(StrategyFactory.createStrategy("Random"));
            System.out.println("random: " + player.selectHand());
            player.setStrategy(StrategyFactory.createStrategy("Rock"));
            System.out.println("rock: " + player.selectHand());
            player.setStrategy(StrategyFactory.createStrategy("Paper"));
            System.out.println("paper " + player.selectHand());
            player.setStrategy(StrategyFactory.createStrategy("Scissor"));// わざとタイピングミスをしている
            System.out.println("scissors " + player.selectHand());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
