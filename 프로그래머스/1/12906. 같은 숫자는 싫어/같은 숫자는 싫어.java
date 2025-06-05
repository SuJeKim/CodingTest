import java.io.*;
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>(); 
        stack.push(arr[0]);
        
        for(int val : arr){
            if(stack.peek() != val){
                stack.push(val);
            }
        }
        
        int[] answer = new int[stack.size()];
        int index = stack.size() - 1;
        while(!stack.empty()){
            answer[index--] = stack.pop();
        }

        return answer;
    }
}