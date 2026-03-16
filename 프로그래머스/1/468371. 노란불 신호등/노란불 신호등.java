class Solution {

    public int solution(int[][] signals) {
        int limit = 1;

        // 모든 신호등 주기의 최소공배수
        for (int[] s : signals) {
            int cycle = s[0] + s[1] + s[2];
            limit = lcm(limit, cycle);
        }

        for (int t = 1; t <= limit; t++) {
            boolean allYellow = true;

            for (int[] s : signals) {
                int g = s[0];
                int y = s[1];
                int r = s[2];
                int cycle = g + y + r;

                int pos = (t - 1) % cycle;  // 0-based 위치

                // 노란불 구간: [g, g+y)
                if (!(g <= pos && pos < g + y)) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return t;
            }
        }

        return -1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}