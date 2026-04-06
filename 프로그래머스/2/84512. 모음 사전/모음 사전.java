import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    String[] vowels = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        // 모든 조합 생성 (빈 문자열부터 시작)
        generate("", 0);
        
        // 생성된 리스트에서 word가 몇 번째인지 찾기
        // (빈 문자열이 첫 번째 index이므로 그대로 반환하면 순서가 맞음)
        return list.indexOf(word);
    }

    private void generate(String str, int len) {
        list.add(str);
        
        // 최대 5글자까지만 생성
        if (len == 5) return;

        for (int i = 0; i < 5; i++) {
            generate(str + vowels[i], len + 1);
        }
    }
}