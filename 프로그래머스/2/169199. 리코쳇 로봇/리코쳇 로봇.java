import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};

    String[][] array;
    boolean[][] visited;

    int n, m;
    int sx, sy, ex, ey= 0; 

    String startStr = "R";
    String endStr = "G";

    public int solution(String[] board) {


        n = board.length;
        m = board[0].length();

        // 배열 만들기
        array = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = board[i].substring(j, j + 1);
                if (startStr.equals(array[i][j])) {
                    sx = i; // 시작점 x
                    sy = j; // 시작점 y
                }
                if (endStr.equals(array[i][j])) {
                    ex = i;
                    ey = j;
                }
            }
        }

        BFS(sx, sy);

        return (endStr.equals(array[ex][ey]) ? -1 : Integer.parseInt(array[ex][ey]));
    }

    public void BFS(int i, int j) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j}); // 큐 맨뒤에 값 삽입

        visited = new boolean[n][m];
        visited[i][j] = true;

        array[i][j] = "0";

        while (!queue.isEmpty()) {
            int now[] = queue.poll(); // 지금의 자리 뽑기

            for (int k = 0; k < 4; k++) { // 상하좌우 탐색 하는데 D나 끝점을 만날때까지 끝까지 가야함.

                // x, y 좌표 구하기
                // 범위를 넘으면 안되고
                // D를 만나거나 혹은 끝까지 전진해야함.
                int x = now[0];
                int y = now[1];

                boolean loop = true;
                while (loop) {
                    x += dx[k];
                    y += dy[k];
                    if (x >= 0 && y >= 0 && x < n && y < m) { // 범위는 넘어갈 수 없고
                        if ("D".equals(array[x][y])) { // 값이 D면 그 전 좌표로 돌아간다.
                            x -= dx[k];
                            y -= dy[k];
                            loop = false;
                        }
                    } else { // 넘어가면 이 전 좌표로 돌리고 loop 종료
                        x -= dx[k];
                        y -= dy[k];
                        loop = false;
                    }
                }

                if( (x == now[0]) && (y == now[1]) ){
                    continue;
                }

                if(!visited[x][y]){ // 방문했던 곳이 아니어야함.
                    if(endStr.equals(array[x][y])){ // 끝나는 지점

                        check(x, y, Integer.valueOf(array[now[0]][now[1]]));
                        queue.clear();
                    }else{ // 끝나는 지점 아님

                        queue.add(new int[]{x, y});
                        check(x, y, Integer.valueOf(array[now[0]][now[1]]));
                    }
                }

            }
        }
    }

    private void check(int x, int y, int move) {
        array[x][y] = String.valueOf(move+1);
        visited[x][y] = true;
    }
}