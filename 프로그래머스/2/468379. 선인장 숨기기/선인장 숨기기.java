import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int INF = drops.length + 1;

        // 1. 각 칸에 비가 오는 시점 기록
        int[][] time = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(time[i], INF);
        }

        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            time[r][c] = i + 1;
        }

        // 2. 각 행에 대해 가로 길이 w의 구간 최소값
        // rowMin[r][c] = time[r][c ~ c+w-1] 의 최소값
        int[][] rowMin = new int[m][n - w + 1];
        for (int r = 0; r < m; r++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int c = 0; c < n; c++) {
                while (!dq.isEmpty() && time[r][dq.peekLast()] >= time[r][c]) {
                    dq.pollLast();
                }
                dq.offerLast(c);

                // 윈도우 범위 밖 제거
                while (!dq.isEmpty() && dq.peekFirst() <= c - w) {
                    dq.pollFirst();
                }

                if (c >= w - 1) {
                    rowMin[r][c - w + 1] = time[r][dq.peekFirst()];
                }
            }
        }

        // 3. 각 열에 대해 세로 길이 h의 구간 최소값
        // 최종적으로 h x w 구역의 최소값이 됨
        int bestValue = -1;
        int bestR = 0;
        int bestC = 0;

        int cols = n - w + 1;

        for (int c = 0; c < cols; c++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int r = 0; r < m; r++) {
                while (!dq.isEmpty() && rowMin[dq.peekLast()][c] >= rowMin[r][c]) {
                    dq.pollLast();
                }
                dq.offerLast(r);

                // 윈도우 범위 밖 제거
                while (!dq.isEmpty() && dq.peekFirst() <= r - h) {
                    dq.pollFirst();
                }

                if (r >= h - 1) {
                    int top = r - h + 1;
                    int value = rowMin[dq.peekFirst()][c];

                    // value가 클수록 더 늦게 비를 맞음
                    // 같은 값이면 더 위쪽, 더 왼쪽을 선택해야 하므로
                    // 행 우선, 열 우선 순서로 탐색하면서 ">"일 때만 갱신
                    if (value > bestValue) {
                        bestValue = value;
                        bestR = top;
                        bestC = c;
                    }
                }
            }
        }

        return new int[]{bestR, bestC};
    }
}