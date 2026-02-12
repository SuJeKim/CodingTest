import java.util.*;

class Solution {

    static class Robot {
        int r, c;       // 현재 위치
        int idx;        // routes에서 현재 목표 인덱스
        int tr, tc;     // 현재 목표 좌표
        boolean active; // 센터 안에 있는지(운송 완료 후 false)

        Robot(int sr, int sc) {
            this.r = sr;
            this.c = sc;
            this.idx = 0;
            this.tr = sr;
            this.tc = sc;
            this.active = true;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int robotCnt = routes.length;
        int pathLen = routes[0].length;

        // 포인트 번호(1..n) -> 좌표
        int n = points.length;
        int[] pr = new int[n + 1];
        int[] pc = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pr[i] = points[i - 1][0];
            pc[i] = points[i - 1][1];
        }

        // 로봇 초기화: 0초 위치는 첫 포인트
        Robot[] robots = new Robot[robotCnt];
        for (int i = 0; i < robotCnt; i++) {
            int start = routes[i][0];
            robots[i] = new Robot(pr[start], pc[start]);
        }

        // 좌표 카운트 (r,c <= 100) → key = r*101 + c
        int[] cnt = new int[101 * 101 + 101];
        int answer = 0;

        while (true) {
            boolean anyActive = false;
            ArrayList<Integer> usedKeys = new ArrayList<>(robotCnt);

            // 1) 이번 초 위치 집계 (도착해도 "그 초"는 포함)
            for (Robot rb : robots) {
                if (!rb.active) continue;
                anyActive = true;

                int key = rb.r * 101 + rb.c;
                if (cnt[key] == 0) usedKeys.add(key);
                cnt[key]++;
            }

            // 모두 종료면 종료
            if (!anyActive) break;

            // 2) 위험 카운트: 이번 초에 같은 칸 2대 이상이면 +1
            for (int key : usedKeys) {
                if (cnt[key] >= 2) answer++;
                cnt[key] = 0; // 초기화
            }

            // 3) 다음 초 이동 준비
            for (int i = 0; i < robotCnt; i++) {
                Robot rb = robots[i];
                if (!rb.active) continue;

                // 현재 목표에 도착해 있으면 다음 목표로 갱신(또는 종료)
                if (rb.r == rb.tr && rb.c == rb.tc) {
                    if (rb.idx == pathLen - 1) {
                        // 마지막 포인트 도착한 상태: 이번 초는 이미 집계했고, 다음 초부터 센터 밖
                        rb.active = false;
                        continue;
                    } else {
                        rb.idx++;
                        int nextPoint = routes[i][rb.idx];
                        rb.tr = pr[nextPoint];
                        rb.tc = pc[nextPoint];
                    }
                }

                // 1칸 이동: r 우선, 그 다음 c
                if (rb.r != rb.tr) {
                    rb.r += (rb.tr > rb.r) ? 1 : -1;
                } else if (rb.c != rb.tc) {
                    rb.c += (rb.tc > rb.c) ? 1 : -1;
                }
            }
        }

        return answer;
    }
}