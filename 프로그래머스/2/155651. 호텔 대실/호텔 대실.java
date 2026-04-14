import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 1. 시간을 분 단위 정수로 변환하여 리스트에 담기
        int[][] times = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++) {
            times[i][0] = parseTime(book_time[i][0]);
            // 종료 시간 + 10분 청소 시간 포함
            times[i][1] = parseTime(book_time[i][1]) + 10;
        }

        // 2. 시작 시간 기준으로 정렬
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        // 3. 우선순위 큐로 가장 빠른 종료 시간 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] book : times) {
            if (pq.isEmpty()) {
                pq.add(book[1]);
                continue;
            }

            // 가장 빨리 비는 방의 종료 시간이 현재 예약 시작 시간보다 작거나 같으면
            if (pq.peek() <= book[0]) {
                pq.poll(); // 기존 방 사용 (시간 갱신을 위해 제거)
            }
            pq.add(book[1]); // 새 시간 또는 갱신된 종료 시간 추가
        }

        return pq.size(); // 큐에 남아있는 데이터 개수가 필요한 방의 개수
    }

    private int parseTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}