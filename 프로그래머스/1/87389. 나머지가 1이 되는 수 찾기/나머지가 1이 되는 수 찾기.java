class Solution {
    public int solution(int n) {
        
        int x = 1; // x는 자연수
        
        while(true){
            if(n % x == 1){
                break;
            }
            x++;
        }
        
        return x;
    }
}