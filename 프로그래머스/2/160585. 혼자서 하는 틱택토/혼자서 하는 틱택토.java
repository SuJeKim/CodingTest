class Solution {

    String[] target;
    boolean possible = false;

    public int solution(String[] board) {
        target = board;

        char[][] map = {
                {'.', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}
        };

        dfs(map, true);

        return possible ? 1 : 0;
    }

    void dfs(char[][] map, boolean oTurn) {

        if (possible) return;

        if (!isValid(map)) return;

        if (isSame(map, target)) {
            possible = true;
            return;
        }

        if (isWin(map, 'O') || isWin(map, 'X')) return;

        char player = oTurn ? 'O' : 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (map[i][j] == '.') {

                    map[i][j] = player;
                    dfs(map, !oTurn);
                    map[i][j] = '.';
                }
            }
        }
    }

    boolean isValid(char[][] map) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (map[i][j] != '.') {
                    if (map[i][j] != target[i].charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean isSame(char[][] map, String[] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (map[i][j] != board[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isWin(char[][] board, char c) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c)
                return true;
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] == c && board[1][j] == c && board[2][j] == c)
                return true;
        }

        if (board[0][0] == c && board[1][1] == c && board[2][2] == c)
            return true;

        if (board[0][2] == c && board[1][1] == c && board[2][0] == c)
            return true;

        return false;
    }
}