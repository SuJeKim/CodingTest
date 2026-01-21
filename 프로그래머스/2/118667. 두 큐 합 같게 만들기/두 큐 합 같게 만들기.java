import java.util.*;
class Solution {

    public int solution(int[] q1, int[] q2) {
        int answer = 0;

        long total = 0; // 두 큐의 합
        long q1sum = 0; // 1번 큐의 합
        Queue<Integer> qq1 = new LinkedList<Integer>();
        Queue<Integer> qq2 = new LinkedList<Integer>();

        for(int i = 0; i < q1.length; i++) {
            total += q1[i] + q2[i];
            q1sum += q1[i];
            qq1.add(q1[i]);
            qq2.add(q2[i]);
        }

        if(total%2!=0) return -1; //만약 두큐의합이 홀수면 같게 못만듦.

        long target = total/2;
        while(true) {
            if(answer>(q1.length+q2.length)*2) return -1;

            if(q1sum==target) break; 
            else if(q1sum>target){   
                q1sum -= qq1.peek(); 
                qq2.add(qq1.poll()); 
            }else{                   
                q1sum += qq2.peek(); 
                qq1.add(qq2.poll()); 
            }
            answer++;
        }

        return answer;
    }
}