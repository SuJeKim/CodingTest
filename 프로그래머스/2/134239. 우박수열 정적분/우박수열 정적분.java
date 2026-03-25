import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> seq = new ArrayList<>();
        seq.add(k);

        // 1. 우박수열 만들기
        long num = k;
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            seq.add((int) num);
        }

        int n = seq.size() - 1; // 구간 개수

        // 2. 구간별 넓이 누적합
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            double area = (seq.get(i) + seq.get(i + 1)) / 2.0;
            prefix[i + 1] = prefix[i] + area;
        }

        // 3. ranges 처리
        double[] answer = new double[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1];

            if (start > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefix[end] - prefix[start];
            }
        }

        return answer;
    }
}