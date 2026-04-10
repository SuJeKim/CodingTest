class Solution {
    public String solution(String s) {
        
         StringBuilder answer = new StringBuilder();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer.append(c);
                index = 0;
            } else {
                answer.append(index % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
                index++;
            }
        }
        return answer.toString();
    }
}