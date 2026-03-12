import java.util.*;

class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        int m = n - 1; // 구매 가능한 번들 개수

        // add[i][s] = i번 번들(= i+1번 스테이지에서 판매)을 샀을 때
        // s번 스테이지(0-based)가 받는 힌트권 수
        int[][] add = new int[m][n];
        int[] price = new int[m];

        for (int i = 0; i < m; i++) {
            price[i] = hint[i][0];
            for (int j = 1; j < hint[i].length; j++) {
                int stage = hint[i][j] - 1; // 1-based -> 0-based
                add[i][stage]++;
            }
        }

        int answer = Integer.MAX_VALUE;

        // mask: 어떤 번들을 구매할지
        for (int mask = 0; mask < (1 << m); mask++) {
            int total = 0;
            int[] cnt = new int[n]; // 각 스테이지별 보유 힌트 수

            // 선택한 번들 적용
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    total += price[i];
                    for (int s = 0; s < n; s++) {
                        cnt[s] += add[i][s];
                    }
                }
            }

            // 각 스테이지 클리어 비용 계산
            for (int s = 0; s < n; s++) {
                int usable = Math.min(cnt[s], n - 1);
                total += cost[s][usable];
            }

            answer = Math.min(answer, total);
        }

        return answer;
    }
}