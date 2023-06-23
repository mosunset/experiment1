import java.util.Random;
class RandomStrategy implements Strategy {
    // add here
    static Random rand = new Random(0);

    public int selectHand() {
        return rand.nextInt(3);
    }
}
