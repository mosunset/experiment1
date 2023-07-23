import java.util.Random;

// インタフェース: MinesweeperのGUIクラスに実装すべきメソッドを定義
interface MineSweeperGUI {
    public void setTextToTile(int x, int y, String text);// タイル(ボタン)のテキストを設定する

    public void win();// ゲーム勝利時の処理

    public void lose(); // ゲーム敗北時の処理
}

public class MineSweeper {

    private final int height; // ボードの高さ
    private final int width; // ボードの幅
    private final int numberOfTiles; // ボードの総タイル数
    private final int numberOfBombs; // 地雷の数
    private final int[][] table; // ボードの状態を表す2次元配列
    // [0-8]:AdjacentBombs,-1:Bom
    private boolean[][] revealed; // タイルの公開状態を保持する2次元配列
    // True:open, False:close
    private boolean[][] flags; // フラグが立っているかどうかを保持する2次元配列
    // True:up, False:down

    public MineSweeper(int height, int width, int numberOfBombs) {// コンストラクタ
        this.height = height;
        this.width = width;
        this.numberOfTiles = height * width;
        this.numberOfBombs = numberOfBombs;
        this.table = new int[height][width];
        this.revealed = new boolean[height][width];
        this.flags = new boolean[height][width];

        initTable();// ボードの初期化
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    // ボードの初期化
    void initTable() {
        setBombs(); // 地雷の設置
        // ここから実装:盤面を初期化する．

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (table[y][x] != -1) {
                    int count = countAdjacentBombs(x, y); // 周囲の地雷数をカウント
                    table[y][x] = count; // ボードの該当位置に周囲の地雷数を設定
                }
            }
        }

    }

    void setBombs() {
        // ここから実装:盤面に地雷をセットする．
        // セットする地雷の数はMineSweeperのインスタンスを生成する際に引数numberOfBombsとして設定されている．
        Random rand = new Random();
        int bombsPlaced = 0;
        while (bombsPlaced < numberOfBombs) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            if (table[y][x] != -1) {
                table[y][x] = -1; // -1は地雷を表す
                bombsPlaced++;
            }
        }
    }

    // タイルの周囲にある地雷の数をカウントする
    private int countAdjacentBombs(int x, int y) {
        int count = 0;
        for (int j = y - 1; j <= y + 1; j++) {
            for (int i = x - 1; i <= x + 1; i++) {
                if (i >= 0 && i < width && j >= 0 && j < height) {
                    if (table[j][i] == -1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void openTile(int x, int y, MineSweeperGUI gui) {
        // ここから実装:パネルを左クリックした際に実行される．
        System.out.printf("%3d%3d  ", x, y);
        System.out.println(table[y][x]);
        gui.setTextToTile(x, y, Integer.toString(table[y][x]));
    }

    public void setFlag(int x, int y, MineSweeperGUI gui) {
        // ここから実装:パネルを右クリックした際に実行される．
        System.out.printf("%3d%3d", x, y);
        System.out.println(table[y][x]);
        gui.setTextToTile(x, y, "▼");
    }

    // TODO:public から private に変更して提出すること
    public void openAllTiles(MineSweeperGUI gui) {
        // ここから実装:全てのパネルを開く．
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (table[y][x] == -1) {
                    gui.setTextToTile(x, y, "★");
                } else {
                    gui.setTextToTile(x, y, Integer.toString(table[y][x]));
                }
            }
        }
    }

}
