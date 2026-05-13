// n의 홀수 약수의 개수 구하는 문제
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i+= 2){
            if(n % i == 0) answer++;
        } 
        return answer;
    }
}