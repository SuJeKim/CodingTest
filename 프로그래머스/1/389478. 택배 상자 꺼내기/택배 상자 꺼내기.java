class Solution {
    public int solution(int n, int w, int num) {
        int row = (num - 1) / w;
        int col;
        
        // num의 실제 세로 위치(col) 구하기
        if (row % 2 == 0) {
            col = (num - 1) % w;
        } else {
            col = w - 1 - ((num - 1) % w);
        }
        
        int lastRow = (n - 1) / w;
        int answer = 0;
        
        // 현재 층부터 마지막 층까지 같은 col에 상자가 있는지 확인
        for (int r = row; r <= lastRow; r++) {
            int boxNum;
            
            if (r % 2 == 0) {
                boxNum = r * w + col + 1;
            } else {
                boxNum = r * w + (w - col);
            }
            
            if (boxNum <= n) {
                answer++;
            }
        }
        
        return answer;
    }
}