import java.util.*;

class Solution {
    public int solution(String s) {
        int answer =0;
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('[' , ']');
        map.put('(' , ')');
        map.put('{' , '}');
        
        for(int i=0; i<s.length(); i++){
            for(char c : s.toCharArray()){
                if(stack.isEmpty()) stack.push(c);
                else{
                    if(map.containsKey(stack.peek())&&map.get(stack.peek()) == c) stack.pop();
                    else stack.push(c);
                }
            }
            
            if(stack.isEmpty()) answer++;
            stack = new Stack<>();
            s = s.substring(1) + s.substring(0,1);
        }
        
        return answer;
    }
}