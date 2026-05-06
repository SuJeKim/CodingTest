import java.lang.*;
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
         Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // n번째 문자 비교
                if(o1.charAt(n) != o2.charAt(n)){
                    // 아스키 코드로 비교
                    return Character.compare(o1.charAt(n), o2.charAt(n));
                }

                // 같으면 문자열 사전순으로 비교
                return o1.compareTo(o2);
            }
        });
        return strings;
    }
}