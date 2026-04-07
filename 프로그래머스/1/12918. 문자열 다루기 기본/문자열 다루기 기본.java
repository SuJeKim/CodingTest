class Solution {
    public boolean solution(String s) {
        
        // 1. 길이
        if(s.length() != 4 && s.length() != 6) return false;
        
        // 2. 숫자
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c < '0' || c > '9'){
                return false;
            }
        }
        
        
        return true;
    }
}