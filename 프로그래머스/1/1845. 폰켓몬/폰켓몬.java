import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // 번호를 map의 key값을 저장
        // 중복 시 + 1
        for(int val : nums){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        // 중복된 포켓몬 -> 한 종류로 따짐.
        // n/2만 선택 가능함 + 가장 많은 종류의 포켓몬
        // map.size() 만큼 선택하면 됨.
        int len = nums.length / 2;
        if(map.size() >= len){
            answer = len;
        }else{
            answer = map.size();
        }
        return answer;
    }
}