import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String inputVal, int n) {
        // 아스키 코드 사용
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < inputVal.length(); i++){
            char ch = inputVal.charAt(i);

            if(ch == ' '){
                answer.append(ch);
                continue;
            }

            // %26 => 알파벳 총 갯수는 26이고 넘치면 나머질 확정
            // 'a' 아스키코드는 97
            if(Character.isLowerCase(ch)){
                ch = (char)((ch - 'a' + n) % 26 + 'a');
            }else if(Character.isUpperCase(ch)){
                ch = (char)((ch - 'A' + n) % 26 + 'A');
            }
            answer.append(ch);
        }
        return  answer.toString();
    }
}