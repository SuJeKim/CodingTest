class Solution {
    public int solution(String name) {
        int answer = 0; // 상하 조작 횟수
        int length = name.length();

        // 좌우 조작 횟수의 최솟값
        int move = length - 1;

        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);

            answer += Math.min(c - 'A', 'Z' - c + 1);

            int nextIndex = i + 1;
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            // 오른쪽으로 i까지 가고
            // U턴해서 뒤부터 방문
            move = Math.min(move, (i * 2) + (length - nextIndex));

            // 왼쪽
            // U턴해서 i까지 방문
            move = Math.min(move, (length - nextIndex) * 2 + i);
        }

        return answer + move;
    }
}