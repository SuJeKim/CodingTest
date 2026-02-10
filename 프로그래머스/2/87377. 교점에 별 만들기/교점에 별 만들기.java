import java.util.*;

class Solution {

    public String[] solution(int[][] line) {
        // x좌표 → y좌표 집합
        Map<Integer, Set<Integer>> crossMap = new HashMap<>();

        // 전체 범위 추적
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;

        // 모든 쌍을 순회 교점 계산
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int ia = line[i][0], ib = line[i][1], ic = line[i][2];
                int ja = line[j][0], jb = line[j][1], jc = line[j][2];

            
                long base = (long) ia * jb - (long) ib * ja;
                long xNumer = (long) ib * jc - (long) ic * jb;
                long yNumer = (long) ic * ja - (long) ia * jc;

                // 평행 + 정수 좌표가 아니면 
                if (base == 0 || xNumer % base != 0 || yNumer % base != 0) continue;

                // 정수 변환
                int x = (int) (xNumer / base), y = (int) (yNumer / base);

                // 교점 좌표 반영
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);

                // 해당 좌표에 y값 저장
                crossMap.computeIfAbsent(x, k -> new HashSet<>()).add(y);
            }
        }

        List<String> answer = new ArrayList<>();

        for (int y = maxY; y >= minY; y--) {
            StringBuilder sb = new StringBuilder();
            for (int x = minX; x <= maxX; x++) {
                
                if (crossMap.containsKey(x) && crossMap.get(x).contains(y)) sb.append('*');
                else sb.append('.');
            }
            answer.add(sb.toString());
        }
        return answer.toArray(new String[0]);
    }
}