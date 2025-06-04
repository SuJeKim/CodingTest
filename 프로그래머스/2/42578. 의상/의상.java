import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            String type = clothes[i][1];
            map.put(type,map.getOrDefault(type,0) + 1);
        }
        
        // 문제 조건에서 최소한 한 개 입음. 
        int answer = 1;
        // 옷 조합: x(곱하기)
        for(String str : map.keySet()){
            // 각 key에서 옷 하나만 선택했을 경우 => +1
            answer *= map.get(str) + 1;
        }
        // 모두 착용했을 경우(같은 key의 종류들을 모두 착용은 불가) => -1
        answer--;
        
        return answer;
    }
}