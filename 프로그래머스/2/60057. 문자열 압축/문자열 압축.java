class Solution {
    public int solution(String s) {
        // 문자열의 최대길이는 압축되지 않은 문자열의 길이
        int answer = s.length();

        // 1 ~ 문자열 길이의 반까지 잘라가며 반복
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            int cnt = 1;
            String compressed = "";
            String target = s.substring(0, i);

            // target과 남은 문자열 비교하기
            for (int j = i; j <= s.length(); j = j + i) {
                int end = Math.min(s.length(), i + j);
                String compare = s.substring(j, end);

                if (compare.equals(target)) {
                    cnt++;
                } else {
                    // cnt가 1일 땐 cnt를 포함시키지 않는다.
                    if (cnt > 1) {
                        compressed += cnt;
                        cnt = 1;
                    }
                    compressed += target;
                    target = compare;
                }
            }

            // 문자열이 i로 나누어 떨어지지 않을 수 있으니 마지막 문자열을 더해준다.
            compressed += target;
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}