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

/*
TODO:KUT WORKSTATION
javac --version
javac 11.0.17

java --version
openjdk 11.0.17 2022-10-18
OpenJDK Runtime Environment (build 11.0.17+8-post-Ubuntu-1ubuntu220.04)
OpenJDK 64-Bit Server VM (build 11.0.17+8-post-Ubuntu-1ubuntu220.04, mixed mode, sharing)
*/

/*
TODO:HOME PC

 */

public class Main extends Frame implements WindowListener, MineSweeperGUI {

    private MineSweeper ms;
    private Button[][] tileTable;
    private static final Font f = new Font("serif", Font.BOLD, 20);
    private static final Font t = new Font("serif", 0, 16);
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
        p3.setSize(50 * ms.getWidth(), 70);
        // p3.setLayout(new BorderLayout());

        Panel p4 = new Panel();
        Panel p5 = new Panel();

        // Label text1 = new Label("マス:");
        TextField textField1 = new TextField(Integer.toString(ms.getHeight()), 5);
        TextField textField3 = new TextField(Integer.toString(ms.getWidth()), 5);
        Label x = new Label("X:Y");
        
        // p4.add(text1);
        p4.add(textField3);
        p4.add(x);
        p4.add(textField1);

        Label text2 = new Label("爆弾:");
        TextField textField2 = new TextField(Integer.toString(ms.getnumberOfBombs()), 5);
        p5.add(text2);
        p5.add(textField2);

        Button btn = new Button();
        btn.setLabel("new Game config:");

        Main pear = this;
        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int num1 = 9;
                int num2 = 10;
                int num3 = 9;
                try {
                    num1 = Integer.parseInt(textField1.getText());
                    num2 = Integer.parseInt(textField2.getText());
                    num3 = Integer.parseInt(textField3.getText());
                    if (50 >= num1 && num1 >= 4 && 50 >= num3 && num3 >= 4 && num1 * num3 - 10 >= num2 && num2 >= 1) {
                        pear.setVisible(false);
                        new Main(num1, num3, num2);
                    } else {
                        throw new Exception();
                    }
                } catch (NumberFormatException ex) {
                    resultDialog.showDialog("整数のみを入力してください");
                } catch (Exception ex) {
                    resultDialog.showDialog("整数のみを入力してください\n([4-50],[1-" + (num1 * num3 - 10) + "])");
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
        text = new Label("地雷原にようこそ！\nマインスイーパーの世界を楽しみましょう！", Label.CENTER);
        text.setSize(50 * ms.getWidth(), 70);
        text.setFont(t);

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
        this.setSize(50 * ms.getWidth(), 50 * ms.getHeight() + 120);
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
        final int fontColors[][] = { { 0, 0, 255 }, { 0, 255, 0 }, { 255, 0, 0 }, { 33, 58, 112 }, { 115, 78, 48 },
                { 0, 140, 243 }, { 0, 0, 0 }, { 107, 107, 107 } };
        Color fontColor;
        // ボタン文字色
        if (1 <= num && num <= 8) {
            int temp = num - 1;
            fontColor = new Color(fontColors[temp][0], fontColors[temp][1], fontColors[temp][2]);
        } else {
            fontColor = this.getBackground();
        }

        this.tileTable[y][x].setForeground(fontColor);
    }

    @Override
    public void setTextTolabel(int tileconfig) {
        String randtexts[] = { "チカチカする数字が近くにあります。うまくタイルを開けてください！", "新しい情報を手に入れました！それを利用して地雷の位置を特定しましょう！",
                "周囲のタイルを確認して、地雷の可能性を排除しましょう！" };
        String bombtexts[] = { "WoW 爆弾が爆発してしまいました。慎重に探索しましょう！", "爆弾が爆発してしまいました！注意が足りなかったようです。",
                "大変！爆弾が爆発したようです。気をつけて次に進みましょう。" };
        String rasttexts[] = { "あと少しで地雷をすべて除去できます。最後まで踏ん張ってください！", "あと少しでゲームクリアです！頑張ってください！",
                "あなたの探索が報われますよ！クリアまであとわずかです！" };
        Random rand = new Random();
        String temp;
        if (tileconfig == -1) {
            temp = bombtexts[rand.nextInt(bombtexts.length)];
        } else if ((ms.getnumberOfTiles() - ms.getOpenTilesCount()) <= ms.getnumberOfBombs() * 1.5) {
            temp = rasttexts[rand.nextInt(rasttexts.length)];
        } else {
            temp = randtexts[rand.nextInt(randtexts.length)];
        }

        text.setText(temp);
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
        label.setFont(new Font("serif", Font.BOLD, 20));
        label.setSize(350,150);
        p1.add(label);
        this.add(p1);
        this.setSize(350, 200);
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
