import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

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
    void initTable(int i, int j) {
        // 仕様1:ゲーム開始時に，盤面にランダムに地雷を設置する
        setBombs(i, j); // 地雷の設置
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
            }
            debug(true, true, true);
            if (numberOfTiles - openTilesCount == numberOfBombs) {// 残りタイル枚数と地雷枚数が同じだった場合勝利
                this.gameEnd = true;
                gui.win(); // 勝利!!!
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
        // TODO:仕様4-1:開かれていないパネルを右クリックした際，そのパネルに旗を立てる/取り除く
        if (!gameEnd) { // ゲーム終了後クリック無反応にする
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

                    gui.setTextToTile(x, y, -1, viewaddflags);
                } else {

                    gui.setTextToTile(x, y, table[y][x], viewaddflags);
                }
            }
        }
    }

}

public class Main extends Frame implements WindowListener, MineSweeperGUI {

    private MineSweeper ms;
    private Button[][] tileTable;
    private static final Font f = new Font("serif", Font.BOLD, 20);
    private final ResultDialog resultDialog = new ResultDialog(this, "Result");

    private Label text;
    private Label bombs;
    private Label closetile;
    private Label flags;

    public Main() {
        super("MineSweeper");
        ms = new MineSweeper(9, 9, 10); // 地雷が10個ある9×9の盤面
        init();
    }

    public Main(int height, int width, int bombs) {
        super("MineSweeper");
        ms = new MineSweeper(height, width, bombs);
        init();
    }

    public static void main(String[] args) {
        new Main();
    }

    private void init() { // ボタン配置＆画面フレームの初期化
        this.tileTable = new Button[ms.getHeight()][ms.getWidth()];
        this.addWindowListener(this);
        this.setLayout(new BorderLayout());
        Panel p1 = new Panel();
        p1.setSize(50 * ms.getWidth(), 50);
        p1.setLayout(new GridLayout(2, 3));

        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(ms.getHeight(), ms.getWidth()));
        p2.setSize(50 * ms.getWidth(), 50 * ms.getHeight());

        Panel p3 = new Panel();
        p3.setSize(50 * ms.getWidth(), 50);
        // p3.setLayout(new BorderLayout());

        Panel p4 = new Panel();
        Panel p5 = new Panel();

        Label text1 = new Label("マス:");
        TextField textField1 = new TextField(Integer.toString(ms.getHeight()), 5);
        p4.add(text1);
        p4.add(textField1);

        Label text2 = new Label("爆弾:");
        TextField textField2 = new TextField(Integer.toString(ms.getnumberOfBombs()), 5);
        p5.add(text2);
        p5.add(textField2);

        Button btn = new Button();
        btn.setLabel("new Game config:");
        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int num1 = Integer.parseInt(textField1.getText());
                    int num2 = Integer.parseInt(textField2.getText());
                    if (50 >= num1 && num1 >= 1 && 2000 >= num2 && num2 >= 1) {
                        new Main(num1, num1, num2);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception ex) {
                    resultDialog.showDialog("正の整数のみを入力してください([1-50],[1-2000])");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        bombs = new Label("爆弾:" + Integer.toString(ms.getnumberOfBombs()), Label.CENTER);

        closetile = new Label("タイル:" + Integer.toString(ms.getnumberOfTiles()), Label.CENTER);

        flags = new Label("フラグ:" + Integer.toString(ms.getflagUpCount()), Label.CENTER);

        for (int i = 0; i < ms.getHeight(); i++) {
            for (int j = 0; j < ms.getWidth(); j++) {
                Button tile = new Button();
                tile.setBackground(new Color(210, 210, 210));
                tile.setFont(f);
                tile.addMouseListener(new MouseEventHandler(ms, this, j, i));
                tileTable[i][j] = tile;
                p2.add(tile);
            }
        }

        text = new Label("          Enjoy This Game!!          ", Label.CENTER);
        text.setSize(50 * ms.getWidth(), 50);
        text.setFont(f);

        p1.add(btn);
        p1.add(p4);
        p1.add(p5);
        p1.add(bombs);
        p1.add(closetile);
        p1.add(flags);
        p3.add(text);
        this.add("North", p1);
        this.add("Center", p2);
        this.add("South", p3);
        this.setSize(50 * ms.getWidth(), 50 * ms.getHeight() + 100);
        this.setLocationRelativeTo(null);// 画面中央配置
        this.setResizable(false);// 最大化ボタン無効
        this.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void setTextToTile(int x, int y, int tableconfig, boolean flag) {
        bombs.setText("爆弾:" + Integer.toString(ms.getnumberOfBombs()));
        closetile.setText("タイル:" + Integer.toString(ms.getnumberOfTiles() - ms.getOpenTilesCount()));
        flags.setText("フラグ:" + Integer.toString(ms.getflagUpCount()));
        if (tableconfig == -2) { // ゲーム中 フラグの設定のみの場合
            setFlagToTile(x, y, flag);
            return;
        } else if (tableconfig == -1) {// ゲーム終了 爆弾の時
            setBombToTile(x, y, flag);
            return;
        } else if (tableconfig != 0) {// ゲーム中 ゲーム終了 マスクリック時
            this.tileTable[y][x].setLabel(Integer.toString(tableconfig));
            tilenumbercolor(x, y, tableconfig);
        }
        if (!ms.getgameEnd()) {
            tilebgcolor(x, y);
        }
    }

    private void setFlagToTile(int x, int y, boolean flag) {
        if (flag) {
            this.tileTable[y][x].setLabel("▼");
        } else {
            this.tileTable[y][x].setLabel("");
        }

    }

    private void setBombToTile(int x, int y, boolean flag) {
        if (flag) {
            this.tileTable[y][x].setLabel("★");
        } else {
            this.tileTable[y][x].setLabel("☆");
        }

    }

    private void tileEnabled(int x, int y) {
        // ボタン無効化
        this.tileTable[y][x].setEnabled(false);
    }

    private void tilebgcolor(int x, int y) {

        // ボタン背景色
        this.tileTable[y][x].setBackground(new Color(170, 170, 170));
    }

    private void tilenumbercolor(int x, int y, int num) {
        Color font;
        // ボタン文字色
        switch (num) {
            case 1:
                font = new Color(0, 0, 255);// 青
                break;
            case 2:
                font = new Color(0, 255, 0);// 緑
                break;
            case 3:
                font = new Color(255, 0, 0);// 赤
                break;
            case 4:
                font = new Color(33, 58, 112);// 紺
                break;
            case 5:
                font = new Color(115, 78, 48);// 茶
                break;
            case 6:
                font = new Color(0, 140, 243);// シアン
                break;
            case 7:
                font = new Color(0, 0, 0);// 黒色
                break;
            case 8:
                font = new Color(107, 107, 107);// 灰色
                break;
            default:
                font = getBackground();
                break;
        }
        this.tileTable[y][x].setForeground(font);
    }

    @Override
    public void win() {
        text.setText("Congratulation! You Win !!!");
        resultDialog.showDialog("You Win !!!");
    }

    @Override
    public void lose() {
        text.setText("Game Over  You Lose ...");
        resultDialog.showDialog("You Lose ...");
    }
}

class MouseEventHandler implements MouseListener {

    MineSweeper ms;
    MineSweeperGUI msgui;
    int x, y;

    MouseEventHandler(MineSweeper ms, MineSweeperGUI msgui, int x, int y) {
        this.ms = ms;
        this.msgui = msgui;
        this.x = x;
        this.y = y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1: {
                // Left click
                ms.openTile(x, y, msgui);
            }
                break;
            case MouseEvent.BUTTON2: {
                // Wheel click
                // TODO:下一行を削除すること
                // ms.openAllTiles(msgui);
            }
                break;
            case MouseEvent.BUTTON3: {
                // Right click
                ms.setFlag(x, y, msgui);
            }
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

class ResultDialog extends Dialog {

    Label label;
    Button btn;

    public ResultDialog(Frame owner, String title) {// 結果表示ダイアログの設定
        super(owner, title);
        setLayout(new GridLayout(2, 1));
        setLocationRelativeTo(null);
        Panel p1 = new Panel();
        label = new Label();
        p1.add(label);
        this.add(p1);
        this.setSize(300, 100);
        btn = new Button();
        btn.setLabel("Close");
        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Window dialog = SwingUtilities.getWindowAncestor(btn);
                if (dialog instanceof Dialog) {
                    Dialog d = (Dialog) dialog;
                    d.dispose();
                }
                // System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        Panel p2 = new Panel();
        p2.add(btn);
        this.add(p2);

    }

    public void showDialog(String message) {
        // Panel p1 = new Panel();
        this.label.setText(message);
        this.setVisible(true);
    }
}