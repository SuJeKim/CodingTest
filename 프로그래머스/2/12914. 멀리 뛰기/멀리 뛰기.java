// 피보나치 수열 활용: f(n) = f(n-1) + f(n-2)
// DP 문제
// 단, 멀리뛰기 방법의 수를 DP에 저장하는 게 아니라
// 1234567나눈 나머지 값을 저장.
class Solution {
    public long solution(int n) {
        if(n == 1) return 1;
        
        long[] dp = new long[n + 1];
        dp[1] = 1; 
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        return dp[n];
    }
}