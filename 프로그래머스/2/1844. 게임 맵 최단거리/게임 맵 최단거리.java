import java.util.*;

class Solution {
    // 이동할 네 방향 (상, 하, 좌, 우)
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // BFS를 위한 큐 생성 (x좌표, y좌표)
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 맵 범위를 벗어나지 않고, 벽이 아니며(1), 아직 방문하지 않은 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    // 이전 칸의 거리 + 1을 현재 칸에 저장 (방문 처리 겸용)
                    maps[nx][ny] = maps[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        
        // 우측 하단 목적지의 값 확인
        int answer = maps[n - 1][m - 1];
        // 처음 값이 1인데 도달하지 못했다면 여전히 1일 것이므로 -1 반환
        return (answer == 1) ? -1 : answer;
    }
}