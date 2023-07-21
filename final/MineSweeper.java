interface MineSweeperGUI {
    public void setTextToTile(int x, int y, String text);

    public void win();

    public void lose();
}

public class MineSweeper {

    private final int height;
    private final int width;
    private final int numberOfTiles;
    private final int numberOfBombs;
    private final int[][] table;

    public MineSweeper(int height, int width, int numberOfBombs) {
        this.height = height;
        this.width = width;
        this.numberOfTiles = height * width;
        this.numberOfBombs = numberOfBombs;
        this.table = new int[height][width];

        initTable();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    void initTable() {
        setBombs();
        // ここから実装:盤面を初期化する．

    }

    void setBombs() {
        // ここから実装:盤面に地雷をセットする．
        // セットする地雷の数はMineSweeperのインスタンスを生成する際に引数numberOfBombsとして設定されている．

    }

    public void openTile(int x, int y, MineSweeperGUI gui) {
        // ここから実装:パネルを左クリックした際に実行される．

    }

    public void setFlag(int x, int y, MineSweeperGUI gui) {
        // ここから実装:パネルを右クリックした際に実行される．

    }

    private void openAllTiles(MineSweeperGUI gui) {
        // ここから実装:全てのパネルを開く．

    }

}
