import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 작업 배포 FIFO
        Queue<Integer> que = new LinkedList<>();
        
        // 배포 단위
        ArrayList<Integer> arr = new ArrayList<>(); 
        
        // progresses.length만큼 순회
        // 100-progresses[i] % speeds[i] == 0 => 몫을 que에 저장.
        // 아니면 하루에 하나만 배포 가능함으로 몫에 + 1
        for(int i = 0; i < progresses.length; i++){
            if((100 - progresses[i]) % speeds[i] == 0){
                que.add((100 - progresses[i]) / speeds[i]);
            }else{
                que.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        // 먼저 que.peek()값 poll
        int work = que.poll();
        // 일단 배포 가능여부와 상관없이 꺼냈으니 기능(횟수)는 1
        int count = 1;
        
        // que가 빌 때까지 반복
        // work가 que.peek()보다 크거나 같을 경우
        // work랑 같이 기능이 배포 count++ 후 poll()
        // 이때, work 초기화 안 함. que.peek() 다음 기능이 work와 크거나 같을 경우
        // 한 번에 배포되어야 함.
        // 그 외의 경우에는 work만 배포되는 거니까 현 기능을 arr에 add 후 
        // count = 1로 초기화 및 work도 초기화.
        while(!que.isEmpty()){
            if(work >= que.peek()){
                count++;
                que.poll();
            }else{
                arr.add(count);
                count = 1;
                work = que.poll();
            }
        }
        arr.add(count);
        int[] answer = new int[arr.size()];
        
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}