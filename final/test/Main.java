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

public class Main extends Frame implements WindowListener, MineSweeperGUI {

    private MineSweeper ms;
    private Button[][] tileTable;
    private static final Font f = new Font("serif", Font.BOLD, 16);
    private final ResultDialog resultDialog = new ResultDialog(this, "Result");

    public Main() {
        super("MineSweeper");
        ms = new MineSweeper(9, 9, 10);  // 地雷が10個ある9×9の盤面
        init();
    }

    public static void main(String[] args) {
        new Main();
    }

    private void init() {
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
    public void setTextToTile(int x, int y, String text) {
        this.tileTable[y][x].setLabel(text);
    }

    @Override
    public void win() {
        resultDialog.showDialog("Win !!!");
    }

    @Override
    public void lose() {
        resultDialog.showDialog("Lose ...");
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

    public ResultDialog(Frame owner, String title) {
        super(owner, title);
        setLayout(new GridLayout(2, 1));
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
        Panel p1 = new Panel();
        this.label.setText(message);
        this.setVisible(true);
    }
}

