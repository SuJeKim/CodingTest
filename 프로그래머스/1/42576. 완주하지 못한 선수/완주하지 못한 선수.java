// 비교하면서 넣는거니까
// 해쉬맵에서 key: 이름, 참여 -> +1, 완주 -> -1
// 최종으로 완주하면 0, 못했으면 1이 됨.
// 현재 hashMap에 key가 없는 상태이기에 
// hm.put("파인애플", hm.getOrDefault("파인애플",0)+1);
import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String ans = "";
        
        Map<String, Integer> hs = new HashMap<>();
        for(int i = 0; i < completion.length; i++) {
            String pa = participant[i];
            String co = completion[i];
            
            // 참가자 리스트 저장
            hs.put(pa, hs.getOrDefault(pa,0) + 1);
            
            // 경쟁자 리스트 저장.
            hs.put(co, hs.getOrDefault(co, 0) -1);
        }
        // 참가자 리스트 마지막 인덱스 저장.
        hs.put(participant[participant.length -1],
              hs.getOrDefault(participant[participant.length -1],0) + 1);
        
        // 해쉬맵에 value가 1이면 완주안함.
        for(String key : hs.keySet()){
           if(hs.get(key) == 1){
               ans = key;
               break;
           } 
        }
        return ans;
    }
}