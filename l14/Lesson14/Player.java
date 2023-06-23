public class Player {
    private Strategy strategy;

    Player(Strategy strategy) {
        this.strategy = strategy;
    }

    public int selectHand() {
        return strategy.selectHand();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
