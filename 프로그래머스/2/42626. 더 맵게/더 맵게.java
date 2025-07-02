import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scoviles = new PriorityQueue<>();
        
        for(int val : scoville) {
            scoviles.offer(val);
        }
        int answer = 0;
        int mix = -1;
        while(scoviles.peek() < K){
            if(scoviles.size() < 2){
                return -1;
            }
            int first = scoviles.poll();
            int second = scoviles.poll();
            
            mix = first + (second * 2);
            answer++;
            scoviles.offer(mix);
            
        }
        
        
        return answer;
    }
}