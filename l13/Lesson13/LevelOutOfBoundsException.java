public class LevelOutOfBoundsException extends Exception {
    public LevelOutOfBoundsException(int msg) {
        super("設定できないレベルです（レベル：" + msg + ")");
    }
}