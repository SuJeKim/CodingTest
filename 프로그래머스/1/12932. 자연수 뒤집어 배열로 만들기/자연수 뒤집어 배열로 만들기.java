import java.util.*;

class Solution {
    public int[] solution(long n) {
        return new StringBuilder(String.valueOf(n))
            .reverse() // 역순
            .toString() 
            .chars() // 스트림
            .map(s -> s - '0')
            .toArray();
    }
}