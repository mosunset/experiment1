import java.util.Random;

// インタフェース: MinesweeperのGUIクラスに実装すべきメソッドを定義
interface MineSweeperGUI {
    public void setTextToTile(int x, int y, int tableconfig, boolean flag);// タイル(ボタン)のテキストを設定する
    // tableconfig:-2 フラグ設定用

    public void win();// ゲーム勝利時の処理

    public void lose(); // ゲーム敗北時の処理
}

public class MineSweeper {

    private final int height; // ボードの高さ
    private final int width; // ボードの幅
    private final int numberOfTiles; // ボードの総タイル数
    private final int numberOfBombs; // 地雷の数
    private int openTilesCount;
    private int flagUpCount;
    private final int[][] table; // ボードの状態を表す2次元配列
    // [0-8]:AdjacentBombs,-1:Bom
    private boolean[][] revealed; // タイルの公開状態を保持する2次元配列
    // True:open, False:close
    private boolean[][] flags; // フラグが立っているかどうかを保持する2次元配列
    // True:up, False:down
    private boolean gameEnd;
    // True:endgame, False:Nostart or playGame
    private boolean firstClick;
    // True:this click is first , False:No first
    // TODO:debugflag
    private int debugcount;

    public MineSweeper(int height, int width, int numberOfBombs) {// コンストラクタ
        this.height = height;
        this.width = width;
        this.numberOfTiles = height * width;
        this.numberOfBombs = numberOfBombs;
        this.openTilesCount = 0;
        this.flagUpCount = 0;
        this.table = new int[height][width];
        this.revealed = new boolean[height][width];
        this.flags = new boolean[height][width];
        this.gameEnd = false;
        this.firstClick = true;

        // TODO:debugflag
        this.debugcount = 0;

        initTable();// ボードの初期化
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getOpenTilesCount() {
        return openTilesCount;
    }

    public int getflagUpCount() {
        return flagUpCount;
    }

    // TODO:削除するかしないか決める
    private void debug(boolean detable, boolean derevealed, boolean deflags) {
        String tb = "";
        String re = "";
        String fg = "";
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (table[y][x] == -1) {
                    tb = "X";
                } else {
                    tb = Integer.toString(table[y][x]);
                }
                if (revealed[y][x]) {
                    re = "v";
                } else {
                    re = " ";
                }
                if (flags[y][x]) {
                    fg = "f";
                } else {
                    fg = " ";
                }
                System.out.print(tb + re + fg + " ");
            }
            System.out.println();
        }
        System.out.printf("\n↑%3d------------open%3d,flag%3d\n", debugcount++, openTilesCount, flagUpCount);
    }

    // ボードの初期化
    void initTable() {
        // 仕様1:ゲーム開始時に，盤面にランダムに地雷を設置する
        
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

                table[y][x] = -1;
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
        // 仕様2:パネルを左クリックした際，パネルを開く
        // 仕様3 パネルを開いた時，そのパネルに地雷が隠されていれば全てのパネルを開く．
        // TODO:仕様4-2:旗が立てられたパネルは，旗が取り除かれるまで左クリックで開けない．
        // TODO:仕様5:ゲームクリアもしくはゲームオーバーになった際，適切なダイアログを表示する.

        if (!gameEnd) { // ゲーム終了後クリック無反応にする

            if (x >= 0 && x < width && y >= 0 && y < height && !revealed[y][x] && !flags[y][x]) {

                revealed[y][x] = true;
                if (table[y][x] == -1) {
                    this.gameEnd = true;
                    gui.lose(); // 地雷をクリックしたら敗北
                    openAllTiles(gui); // 全てのタイルをオープンして地雷を表示
                } else if (table[y][x] == 0) {

                    gui.setTextToTile(x, y, 0, false);// 0の場合も表示
                    openTilesCount++;
                    openAdjacentTiles(x, y, gui); // 周囲のタイルを再帰的にオープン
                } else {

                    gui.setTextToTile(x, y, table[y][x], false); // タイルに地雷数を表示
                    openTilesCount++;
                }
            }
            debug(true, true, true);
            if (numberOfTiles - openTilesCount == numberOfBombs) {// 残りタイル枚数と地雷枚数が同じだった場合勝利
                this.gameEnd = true;
                gui.win();
                openAllTiles(gui); // 全てのタイルをオープンして地雷を表示
            }
        }
    }

    // タイルの周囲のタイルを再帰的にオープンする
    private void openAdjacentTiles(int x, int y, MineSweeperGUI gui) {
        for (int j = y - 1; j <= y + 1; j++) {
            for (int i = x - 1; i <= x + 1; i++) {
                if (i >= 0 && i < width && j >= 0 && j < height && !revealed[j][i] && !flags[j][i]) {// TODO:自動で開く時のフラグの関係をどうするかレポートに書く(!flags[j][i])の部分

                    revealed[j][i] = true;
                    if (table[j][i] == 0) {

                        gui.setTextToTile(i, j, 0, false);// 0の場合も表示
                        openTilesCount++;
                        openAdjacentTiles(i, j, gui);
                    } else if (table[j][i] != -1) {

                        gui.setTextToTile(i, j, table[j][i], false);
                        openTilesCount++;
                    }
                }
            }
        }
    }

    public void setFlag(int x, int y, MineSweeperGUI gui) {
        // ここから実装:パネルを右クリックした際に実行される．
        // TODO:仕様4-1:開かれていないパネルを右クリックした際，そのパネルに旗を立てる/取り除く
        if (!gameEnd) { // ゲーム終了後クリック無反応にする
            if (x >= 0 && x < width && y >= 0 && y < height && !revealed[y][x]) {
                if (!this.flags[y][x]) {

                    gui.setTextToTile(x, y, -2, true); // タイルにフラグを表示
                    this.flags[y][x] = true;
                    this.flagUpCount++;
                } else {

                    gui.setTextToTile(x, y, -2, false); // フラグを削除
                    this.flags[y][x] = false;
                    this.flagUpCount--;
                }
            }
            debug(true, true, true);
        }
    }

    // TODO:public から private に変更して提出すること
    public void openAllTiles(MineSweeperGUI gui) {
        // ここから実装:全てのパネルを開く．
        Boolean viewaddflags = false;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                revealed[y][x] = true;
                if (flags[y][x] == true) {// ゲーム中フラグにした個所を可視化

                    viewaddflags = true;
                } else {

                    viewaddflags = false;
                }
                if (table[y][x] == -1) {

                    // gui.setTextToTile(x, y, viewaddflags + "★");// 爆弾の表記
                    gui.setTextToTile(x, y, -1, viewaddflags);
                } else {

                    gui.setTextToTile(x, y, table[y][x], viewaddflags);
                }
            }
        }
    }

}
