class Solution {

    public int solution(int storey) {
        int cnt = 0;

        while (storey != 0) {
            int n = storey % 10;  // 현재 자리
            storey /= 10;         // 상위 자리 이동

            if (n == 0) continue;  

            else if (n < 5) {
                cnt += n; 
            }
            else if (n > 5) {
                // 올림 처리
                cnt += 10 - n;
                storey++;  // 다음 자리에 올림 
            }
            else {
                cnt += 5;
                if (storey % 10 >= 5) storey++;  
            }
        }

        return cnt;
    }
}