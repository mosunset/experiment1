public class NameOutOfBoundsException extends Exception {
    public NameOutOfBoundsException(String msg) {
        super("設定できない名前です（名前：" + msg + ")");
    }
}