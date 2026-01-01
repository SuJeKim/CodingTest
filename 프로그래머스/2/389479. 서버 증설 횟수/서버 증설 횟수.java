import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int count = 0;
        Queue<Integer> active = new LinkedList<>();

        for (int i = 0; i < 24; i++) {
            int need = players[i] / m;

            while (!active.isEmpty() && active.peek() <= i) {
                active.poll();
            }

            int current = active.size();

            if (current < need) {
                int newServer = need - current;
                count += newServer;
                for (int j = 0; j < newServer; j++) {
                    active.offer(i + k);
                }
            }
        }

        return count;
    }
}