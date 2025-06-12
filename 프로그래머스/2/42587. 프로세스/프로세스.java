import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 우선순위 큰 숫자가 나옴.
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int val : priorities){
            que.offer(val);
        }
        while(!que.isEmpty()){
          for(int i = 0; i < priorities.length; i++){
              if(priorities[i] == que.peek()){
                  que.poll();
                  answer++;
                  if(i == location){
                      return answer;
                  }
              }
          }  
        }
        
        return answer;
    }
}