class Solution {
    int answer = 0;

    public int solution(int n, int[][] q, int[] ans) {
        int[] picked = new int[5];
        comb(1, 0, n, q, ans, picked);
        return answer;
    }

    // 1~n 중 5개 조합 만들기
    private void comb(int start, int depth, int n, int[][] q, int[] ans, int[] picked) {
        if (depth == 5) {
            if (isValid(picked, q, ans)) {
                answer++;
            }
            return;
        }

        for (int num = start; num <= n; num++) {
            picked[depth] = num;
            comb(num + 1, depth + 1, n, q, ans, picked);
        }
    }

    // 현재 조합이 모든 시도 결과와 맞는지 검사
    private boolean isValid(int[] picked, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int count = 0;

            for (int a = 0; a < 5; a++) {
                for (int b = 0; b < 5; b++) {
                    if (picked[a] == q[i][b]) {
                        count++;
                    }
                }
            }

            if (count != ans[i]) {
                return false;
            }
        }
        return true;
    }
}