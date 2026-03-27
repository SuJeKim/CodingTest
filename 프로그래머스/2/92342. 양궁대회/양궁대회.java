import java.util.*;

class Solution {
    int maxDiff = -1;
    int[] best = new int[11];

    public int[] solution(int n, int[] info) {
        int[] lion = new int[11];
        dfs(0, n, lion, info);

        if (maxDiff == -1) {
            return new int[]{-1};
        }

        return best;
    }

    private void dfs(int idx, int arrows, int[] lion, int[] info) {
        // 10개 점수칸(10점~1점)까지 다 확인한 경우
        if (idx == 10) {
            lion[idx] = arrows; // 남은 화살은 0점 칸에 몰아주기

            int diff = getScoreDiff(lion, info);

            if (diff > 0) {
                if (diff > maxDiff) {
                    maxDiff = diff;
                    best = lion.clone();
                } else if (diff == maxDiff) {
                    if (isBetter(lion, best)) {
                        best = lion.clone();
                    }
                }
            }

            lion[idx] = 0; // 원상복구
            return;
        }

        // 1. 해당 점수칸을 이기기 위해 필요한 만큼 쏘는 경우
        int need = info[idx] + 1;
        if (arrows >= need) {
            lion[idx] = need;
            dfs(idx + 1, arrows - need, lion, info);
            lion[idx] = 0;
        }

        // 2. 해당 점수칸을 포기하는 경우
        dfs(idx + 1, arrows, lion, info);
    }

    private int getScoreDiff(int[] lion, int[] info) {
        int lionScore = 0;
        int apeachScore = 0;

        for (int i = 0; i < 11; i++) {
            if (lion[i] == 0 && info[i] == 0) continue;

            int score = 10 - i;

            if (lion[i] > info[i]) {
                lionScore += score;
            } else {
                apeachScore += score;
            }
        }

        return lionScore - apeachScore;
    }

    // 점수 차가 같을 때, 더 낮은 점수를 많이 맞힌 배열이 우선
    private boolean isBetter(int[] lion, int[] best) {
        for (int i = 10; i >= 0; i--) {
            if (lion[i] > best[i]) return true;
            if (lion[i] < best[i]) return false;
        }
        return false;
    }
}