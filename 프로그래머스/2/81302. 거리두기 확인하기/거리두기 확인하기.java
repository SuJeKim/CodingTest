import java.util.*;

class Solution {
    int n = 5;
    int[][] checkLoc = {{1,0},{2,0},{0,1},{0,2},{1,1},{1,-1}};
    public int[] solution(String[][] places) {
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            ans[i] = check(places[i]);
        }
        return ans;
    }
    int check(String[] place){
        for(int i = 0 ; i < n*n ; i++){
            int r1 = i / n;
            int c1 = i % n;
            if(place[r1].charAt(c1) != 'P') continue;
            
            for(int j = 0 ; j < 6 ; j++){
                int r2 = r1+checkLoc[j][0];
                int c2 = c1+checkLoc[j][1];
                
                if(OOB(r2,c2) || place[r2].charAt(c2) != 'P') continue;
                
                if(getDist(r1,c1,r2,c2) == 1) return 0;
                
                if(existPartition(r1,c1,r2,c2, place)) continue;
                return 0;
            }
        }
        return 1;
    }
    int getDist (int r1,int c1,int r2,int c2){
        return Math.abs(r1-r2) + Math.abs(c1-c2);
    }
    boolean existPartition(int r1,int c1,int r2,int c2, String[] place){
        int sr = Math.min(r1,r2);
        int er = Math.max(r1,r2);
        int sc = Math.min(c1,c2);
        int ec = Math.max(c1,c2);
        
        for(int i = sr ; i <= er ; i++){
            for(int j = sc ; j <= ec ; j++){
                if((i == r1 && j == c1 )|| (i == r2 && j == c2)) continue;
 
                if(place[i].charAt(j) != 'X') return false;
            }
        }
        return true;
    }
    boolean OOB(int r,int c){
        return r < 0 || r >= n || c < 0 || c >= n;
    }
}