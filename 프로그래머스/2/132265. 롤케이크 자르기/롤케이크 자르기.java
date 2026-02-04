import java.util.*;

class Solution {

    public int solution(int[] topping) {
        Set<Integer> left = new HashSet<>();                 // 왼쪽 조각의 토핑 종류
        Map<Integer, Integer> right = new HashMap<>();       // 오른쪽 조각의 토핑 개수

        Arrays.stream(topping).forEach(t -> right.merge(t, 1, Integer::sum));

        int answer = 0;
        
        for (int t : topping) {
            left.add(t);                             
            right.merge(t, -1, Integer::sum);       
            if (right.get(t) <= 0) right.remove(t);  
            if (left.size() == right.size()) answer++;
            if (left.size() > right.size()) break;
        }

        return answer;
    }
}