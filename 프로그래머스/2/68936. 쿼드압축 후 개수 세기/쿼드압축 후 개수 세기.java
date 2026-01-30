class Solution {
    static int [] answer = new int [2]; 
    static int [][] map;
    static int cnt = 0;
    public int[] solution(int[][] arr) {
        map = arr;
        conquer(0, arr.length, 0, arr.length);
        return answer;
    }
    // 분할 정복 
    public static void conquer(int sx, int ex, int sy, int ey){
         int cnt1 = 0; 
         int cnt2 = 0; 
         for(int i = sx; i < ex; i++){
             for(int j = sy; j < ey; j++){
                 if(map[i][j] == 0) cnt1++;
                 else cnt2++;
             }
         }
         if((cnt1 == 0 && cnt2 != 0) || (cnt1 != 0 && cnt2 == 0)){
            if(cnt1 > 0) answer[0]++;
            else answer[1]++;
            return;
         }
         int mx = (ex - sx) / 2;
         int my = (ey - sy) / 2;
         for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                conquer(sx + (mx * i), sx + (mx * (i+1)), sy + (my * j), sy + (my * (j+1)));
            }
         } 
    }
}