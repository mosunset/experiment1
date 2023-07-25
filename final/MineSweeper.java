import java.util.Random;

// インタフェース: MinesweeperのGUIクラスに実装すべきメソッドを定義
interface MineSweeperGUI {
    public void setTextToTile(int x, int y, int tableconfig, boolean flag);// タイル(ボタン)のテキストを設定する
    // tableconfig:-2 フラグ設定用

    public void setTextTolabel(int tileconfig);// ゲーム中表示される文章を変更する

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

        // ファーストクリック仕様作成につき削除
        // initTable();// ボードの初期化
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

    public boolean getgameEnd() {
        return gameEnd;
    }

    public int getnumberOfBombs() {
        return numberOfBombs;
    }

    public int getnumberOfTiles() {
        return numberOfTiles;
    }

    // TODO:削除するかしないか決める
    private void debug() {
        String tb, re, fg;
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
        System.out.printf("\n↑%3d------------open:%3d, flag:%3d\n", debugcount++, openTilesCount, flagUpCount);
    }

    // ボードの初期化
    void initTable(int i, int j) {
        // 仕様1:ゲーム開始時に，盤面にランダムに地雷を設置する
        setBombs(i, j); // 地雷の設置
        // ここから実装:盤面を初期化する．

        for (int y = 0; y < height; y++) {// すべてのマスをチェック
            for (int x = 0; x < width; x++) {
                if (table[y][x] != -1) {// 爆弾じゃないとき

                    int count = countAdjacentBombs(x, y); // 周囲の地雷数をカウント
                    table[y][x] = count; // ボードの該当位置に周囲の地雷数を設定
                }
            }
        }
        // debug(true, true, true);

    }

    void setBombs(int i, int j) {
        // ここから実装:盤面に地雷をセットする．
        // セットする地雷の数はMineSweeperのインスタンスを生成する際に引数numberOfBombsとして設定されている．
        Random rand = new Random();

        // ファーストクリック仕様のための初期化
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                table[y][x] = 0;
            }
        }

        int bombsPlaced = 0;
        while (bombsPlaced < numberOfBombs) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);

            // (i, j) の周囲3x3マスに(x, y)が含まれる場合はスキップ
            // 最初のクリック時そのマスが0になるまで初期化する TODO:レポートに書く
            if (Math.abs(x - i) <= 1 && Math.abs(y - j) <= 1) {
                continue;
            }

            if (table[y][x] != -1) {

                table[y][x] = -1;
                bombsPlaced++;
            }
        }
    }

    // タイルの周囲にある地雷の数をカウントする
    private int countAdjacentBombs(int x, int y) {
        int count = 0;
        for (int j = y - 1; j <= y + 1; j++) {// 周囲をチェック
            for (int i = x - 1; i <= x + 1; i++) {
                if (i >= 0 && i < width && j >= 0 && j < height) {// エラー箇所を排除

                    if (table[j][i] == -1) {// 爆弾だったとき

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
        // 仕様4-2:旗が立てられたパネルは，旗が取り除かれるまで左クリックで開けない．
        // 仕様5:ゲームクリアもしくはゲームオーバーになった際，適切なダイアログを表示する.

        if (gameEnd) { // ゲーム終了後クリック無反応にする
            return;
        }

        if (x >= 0 && x < width && y >= 0 && y < height && !revealed[y][x] && !flags[y][x]) {
            if (firstClick) {
                initTable(x, y);
                firstClick = false;
            }

            revealed[y][x] = true;
            if (table[y][x] == -1) {
                this.gameEnd = true;
                gui.lose(); // 地雷をクリックしたら敗北
                openAllTiles(gui); // 全てのタイルをオープンして地雷を表示
            } else if (table[y][x] == 0) {
                openTilesCount++;
                gui.setTextToTile(x, y, 0, false);// 0の場合も表示

                openAdjacentTiles(x, y, gui); // 周囲のタイルを再帰的にオープン
            } else {
                openTilesCount++;
                gui.setTextToTile(x, y, table[y][x], false); // タイルに地雷数を表示
            }

            if (!gameEnd && table[y][x] != -1) {
                gui.setTextTolabel(table[y][x]);// labelテキストの変更
            } else {
                gui.setTextTolabel(table[y][x]);// labelテキストの変更
            }

        }
        debug();

        if (numberOfTiles - openTilesCount == numberOfBombs) {// 残りタイル枚数と地雷枚数が同じだった場合勝利
            this.gameEnd = true;
            gui.win(); // 勝利!!!
            openAllTiles(gui); // 全てのタイルをオープンして地雷を表示
        }

    }

    // タイルの周囲のタイルを再帰的にオープンする
    private void openAdjacentTiles(int x, int y, MineSweeperGUI gui) {
        for (int j = y - 1; j <= y + 1; j++) {
            for (int i = x - 1; i <= x + 1; i++) {

                // TODO:自動で開く時のフラグの関係をどうするかレポートに書く(!flags[j][i])の部分
                if (i >= 0 && i < width && j >= 0 && j < height && !revealed[j][i] && !flags[j][i]) {

                    revealed[j][i] = true;
                    if (table[j][i] == 0) {
                        openTilesCount++;
                        gui.setTextToTile(i, j, 0, false);// 0の場合も表示

                        openAdjacentTiles(i, j, gui);
                    } else if (table[j][i] != -1) {
                        openTilesCount++;
                        gui.setTextToTile(i, j, table[j][i], false);

                    }
                }
            }
        }
    }

    public void setFlag(int x, int y, MineSweeperGUI gui) {
        // ここから実装:パネルを右クリックした際に実行される．
        // 仕様4-1:開かれていないパネルを右クリックした際，そのパネルに旗を立てる/取り除く
        if (gameEnd) { // ゲーム終了後クリック無反応にする
            return;
        }
        if (x >= 0 && x < width && y >= 0 && y < height && !revealed[y][x]) {
            if (firstClick) {
                return;
            }
            if (!this.flags[y][x]) {
                this.flags[y][x] = true;
                this.flagUpCount++;
                gui.setTextToTile(x, y, -2, true); // タイルにフラグを表示

            } else {
                this.flags[y][x] = false;
                this.flagUpCount--;
                gui.setTextToTile(x, y, -2, false); // フラグを削除

            }
        }
        debug();
    }

    private void openAllTiles(MineSweeperGUI gui) {
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

                gui.setTextToTile(x, y, table[y][x], viewaddflags);

            }
        }
    }

}
