/**
row번째 행에 퀸을 배치하고 다음 행으로 넘어가는 재귀 탐색
 => 열이나 대각선에 이미 퀸이 있다면 건너뜀
**/

class Solution {

    public int solution(int n) {
        return patternCount(0, n, new boolean[n], new boolean[n * 2 - 1], 
                            new boolean[n * 2 - 1]);
    }

    public int patternCount(int row, int n, boolean[] colUsed, boolean[] diag1, boolean[] diag2) {
        if (row == n) return 1;  // 모든 행에 퀸 배치 → 유효한 경우 1 반환

        int cnt = 0;

        for (int col = 0; col < n; col++) {
            if (colUsed[col] || diag1[row + col] || diag2[row - col + n - 1]) continue;

            // 퀸 배치
            colUsed[col] = diag1[row + col] = diag2[row - col + n - 1] = true;

            //재귀 호출
            cnt += patternCount(row + 1, n, colUsed, diag1, diag2);

            // backtracking
            colUsed[col] = diag1[row + col] = diag2[row - col + n - 1] = false;
        }

        return cnt;
    }
}