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

        /* ----- ここから実装してください． ----- */
        
    }

    void setBombs() {
        /* ----- ここから実装してください． ----- */
        
    }

    public void openTile(int x, int y, MineSweeperGUI gui) {
        /* ----- ここから実装してください． ----- */
    }

    public void setFlag(int x, int y, MineSweeperGUI gui) {
        /* ----- ここから実装してください． ----- */
    }

    private void openAllTiles(MineSweeperGUI gui) {
        /* ----- ここから実装してください． ----- */
    }

}
