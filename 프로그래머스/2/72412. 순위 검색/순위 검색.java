import java.util.*;

class Solution {
    private Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        // 1. info의 모든 조합 저장
        for (String s : info) {
            String[] arr = s.split(" ");
            makeCase(0, "", arr);
        }

        // 2. 각 key의 점수 리스트 정렬
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        // 3. query 처리
        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String q = query[i].replaceAll(" and ", " ");
            String[] arr = q.split(" ");

            String key = arr[0] + arr[1] + arr[2] + arr[3];
            int score = Integer.parseInt(arr[4]);

            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            answer[i] = list.size() - lowerBound(list, score);
        }

        return answer;
    }

    // 가능한 16가지 key 생성
    private void makeCase(int depth, String key, String[] arr) {
        if (depth == 4) {
            int score = Integer.parseInt(arr[4]);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }

        // 현재 조건 그대로 사용
        makeCase(depth + 1, key + arr[depth], arr);

        // 와일드카드(-) 사용
        makeCase(depth + 1, key + "-", arr);
    }

    // score 이상이 처음 나오는 인덱스
    private int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}