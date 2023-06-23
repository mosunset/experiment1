public class StrategyFactory {
    public static Strategy createStrategy(String type) {
        switch (type) {
            case "Rock":
                return new RockStrategy();
            // add here
            case "Random":
                return new RandomStrategy();
            case "Scissors":
                return new ScissorsStrategy();
            case "Paper":
                return new PaperStrategy();
            default:
                throw new IllegalArgumentException("Invalid strategy type: " + type);
        }

    }
}
