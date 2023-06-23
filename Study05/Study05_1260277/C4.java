public class C4 {
    static public void main(String[] args) {
        Board board = new Board();
        boolean hasEmptySpaces = true; // 空きマスがあるか

        while (true) {
            int player = board.getCurrentPlayer();

            // 先手 1 ○ 後手 2 ×
            board.showBoard(); // 盤面表示

            board.placeRandomPiece(player); // 駒配置

            if (board.isWinner(player)) { // 勝利条件を満たした場合の勝敗判定
                break;
            }

            hasEmptySpaces = board.hasEmptySpaces(); // 空きのマス判定
            if (!hasEmptySpaces) {
                break;
            }

            board.switchPlayer();
        }

        board.showBoard(); // 盤面表示

        if (!hasEmptySpaces) { //
            System.out.println("引き分けです");
        } else if (board.getCurrentPlayer() == 1) { // 勝敗判定ができる時の場合分け
            System.out.println("先手が勝ちました");
        } else {
            System.out.println("後手が勝ちました");
        }
    }
}
