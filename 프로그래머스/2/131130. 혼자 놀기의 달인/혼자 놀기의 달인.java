import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                int cnt = 0;
                int cur = i;

                while(!visited[cur]){
                    visited[cur] = true;
                    cur = cards[cur] - 1;
                    cnt++;
                }

                list.add(cnt);
            }
        }

        if(list.size() < 2) return 0;

        Collections.sort(list, Collections.reverseOrder());

        return list.get(0) * list.get(1);
    }
}