import java.util.Random;

public class Board {
    private int[][] squares; // 盤面の状態を表す2次元配列
    private int currentPlayer; // 現在のプレイヤー(先手: 1 ○, 後手: 2 ×)

    // 乱数は実行毎に同じ結果を得るため, 乱数のseed を0 に設定する
    static private Random random = new Random(0);

    Board() {
        squares = new int[5][5]; // 5x5の盤面を作成
        currentPlayer = 1; // 先手でゲームを開始
        initializeBoard();
    }

    // 盤面を初期化
    private void initializeBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                squares[i][j] = 0; // すべてのマスを空にする
            }
        }
    }

    // 0から4の乱数を生成
    private int random125() {
        return random.nextInt(5);
    }

    // 指定されたプレイヤーの駒をランダムな位置に配置
    // 配置された駒の座標とプレイヤーを表示
    public void placeRandomPiece(int player) {
        int x, y;
        do {
            x = random125();
            y = random125();
        } while (!isLegalMove(x, y));
        squares[y][x] = player;

        if (player == 1) {
            System.out.print("先手は ");
        } else {
            System.out.print("後手は ");
        }
        System.out.println(x + " " + y + " に置きました");

    }

    // 指定された座標に駒を配置できるかどうかを判定
    private boolean isLegalMove(int x, int y) {
        if (squares[y][x] != 0) {
            return false; // 既に駒が置かれている場合は置けない
        }
        return true;
    }

    // 現在のプレイヤーを切り替える。 1が先手プレイヤー（○）,2が後手プレイヤー（×）
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    // ゲームの終了判定 : ゲームボードに空きのマスがあるかどうかを判定（勝敗がついた時とは別）
    public boolean hasEmptySpaces() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (squares[row][col] == 0) {
                    return true; // 空きマスがある場合はtrueを返す
                }
            }
        }
        return false; // 空きマスがない場合はfalseを返す
    }

    // ゲームの終了&勝敗判定 : 指定されたプレイヤーが勝利条件（4目並べた）を満たしているかどうかを判定
    public boolean isWinner(int player) {
        boolean win = false; // 斜め方向判定のための変数

        // 水平方向の勝利判定
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col <= 1; col++) {
                if (squares[row][col] == player &&
                        squares[row][col + 1] == player &&
                        squares[row][col + 2] == player &&
                        squares[row][col + 3] == player) {
                    win = true; // 水平方向に4つの駒が並んでいれば勝利
                }
            }
        }

        // 垂直方向の勝利判定
        for (int col = 0; col < 5; col++) {
            for (int row = 0; row <= 1; row++) {
                if (squares[row][col] == player &&
                        squares[row + 1][col] == player &&
                        squares[row + 2][col] == player &&
                        squares[row + 3][col] == player) {
                    win = true; // 垂直方向に4つの駒が並んでいれば勝利
                }
            }
        }

        // // 斜め方向の勝敗判定
        // if (!win) {
        // return isWinnerOblique(player);
        // }

        return win; // 勝利していればtrueを返す
    }

    // 斜め方向の勝利条件を判定。右下がりと右上がりの2つの方向をチェックする
    private boolean isWinnerOblique(int player) {
        // 右下がり方向の勝利判定
        for (int col = 0; col <= 1; col++) {
            for (int row = 0; row <= 1; row++) {
                if (squares[row][col] == player &&
                        squares[row + 1][col + 1] == player &&
                        squares[row + 2][col + 2] == player &&
                        squares[row + 3][col + 3] == player) {
                    return true; // 右下がり方向に4つの駒が並んでいれば勝利
                }
            }
        }

        // 右上がり方向の勝利判定
        for (int col = 3; col <= 4; col++) {
            for (int row = 0; row <= 1; row++) {
                if (squares[row][col] == player &&
                        squares[row + 1][col - 1] == player &&
                        squares[row + 2][col - 2] == player &&
                        squares[row + 3][col - 3] == player) {
                    return true; // 右上がり方向に4つの駒が並んでいれば勝利
                }
            }
        }
        return false; // 勝利していない場合はfalseを返す
    }

    // 現在のプレイヤーを返す
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    // 現在の盤面の状態を表示
    public void showBoard() {
        System.out.println("  0 1 2 3 4"); // 列番号の表示
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (col == 0) {
                    System.out.print(row + " "); // 行番号の表示
                }
                switch (squares[row][col]) {
                    case 0:
                        System.out.print("_ "); // 空きマスを表示
                        break;
                    case 1:
                        System.out.print("o "); // 先手の駒を表示
                        break;
                    case 2:
                        System.out.print("x "); // 後手の駒を表示
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
