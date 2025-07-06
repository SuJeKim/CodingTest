import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int val = 0; val < commands.length; val++){
            int i = commands[val][0];
            int j = commands[val][1];
            int k = commands[val][2];
            
            int[] slicedArr = Arrays.copyOfRange(array,i - 1,j);
            Arrays.sort(slicedArr);
            
            answer[val] = slicedArr[k - 1];
        }
        
        return answer;
    }
}