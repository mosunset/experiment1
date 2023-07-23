import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.util.Random;

public class Main extends Frame implements WindowListener, MineSweeperGUI {

    private MineSweeper ms;
    private Button[][] tileTable;
    private static final Font f = new Font("serif", Font.BOLD, 16);
    private final ResultDialog resultDialog = new ResultDialog(this, "Result");

    public Main() {
        super("MineSweeper");
        ms = new MineSweeper(9, 9, 10); // 地雷が10個ある9×9の盤面
        init();
    }

    public static void main(String[] args) {
        new Main();
    }

    private void init() { // ボタン配置＆画面フレームの初期化
        this.tileTable = new Button[ms.getHeight()][ms.getWidth()];
        this.addWindowListener(this);
        this.setLayout(new GridLayout(ms.getHeight(), ms.getWidth()));
        for (int i = 0; i < ms.getHeight(); i++) {
            for (int j = 0; j < ms.getWidth(); j++) {
                Button tile = new Button();
                tile.setBackground(Color.LIGHT_GRAY);
                tile.setFont(f);
                tile.addMouseListener(new MouseEventHandler(ms, this, j, i));
                tileTable[i][j] = tile;
                this.add(tile);
            }
        }
        this.setSize(50 * ms.getWidth(), 50 * ms.getHeight());
        this.setLocationRelativeTo(null);
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
        if (tableconfig == -2) { // ゲーム中 フラグの設定のみの場合
            setFlagToTile(x, y, flag);
            return;
        } else if (tableconfig == -1) {// ゲーム終了 爆弾の時
            setBombToTile(x, y, flag);
        } else if (tableconfig != 0) {// ゲーム中 ゲーム終了 マスクリック時
            this.tileTable[y][x].setLabel(Integer.toString(tableconfig));
        }
        tilecolor(x, y);
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

    private void tilecolor(int x, int y) {
        // ボタン無効化
        // this.tileTable[y][x].setEnabled(false);
        // ボタン背景色
        this.tileTable[y][x].setBackground(Color.gray);
        this.tileTable[y][x].setForeground(getBackground());
    }

    @Override
    public void win() {
        resultDialog.showDialog("You Win !!!");
    }

    @Override
    public void lose() {
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
                ms.openAllTiles(msgui);
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
        this.setSize(200, 100);
        btn = new Button();
        btn.setLabel("exit");
        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
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
