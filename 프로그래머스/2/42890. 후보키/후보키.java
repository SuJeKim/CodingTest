import java.util.*;

class Solution {
 
    static int n,m; // 컬럼의 개수 => row 개수  
    static boolean [] local;  // 현재 상태  
    static int answer = 0;
    static String [][] r;
    static ArrayList<ArrayList<Integer>> keys = new ArrayList<>();
   
    // 후보 키로 사용 못 하는 컬럼들 
    static HashSet<Integer> nextGlobal = new HashSet<>();
    
    
    public int solution(String[][] relation) {
        r = relation;
        n = relation[0].length; // 컬럼의 개수 
        m = relation.length; // row 개수 
        
        local = new boolean [n];
        
        // 후보키 컬럼 개수만큼 
        for(int i = 1; i <= n; i++){
            choose(0, i, 0);
        }
        return answer;
    }
    
    // cnt: 중복 방지
    public static void choose(int depth, int end, int cnt){
        if(depth == end){
            candidateKey();
            return;
        }
        for(int i = cnt; i < n; i++){
            if(local[i]) continue;
            local[i] = true;
            choose(depth + 1, end, i + 1);
            local[i] = false;
        }
    }
    public static void candidateKey(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(local[i]) list.add(i);
        }
        
        // 최소성 테스트 
        for(ArrayList<Integer> key : keys){
            int cnt = 0;
            for(int next : key){
                if(list.contains(next)) cnt++;
            }
            if(cnt == key.size()) return;
        }
        
        // 유일성 테스트 
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < m; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < list.size(); j++){
                sb.append(r[i][list.get(j)]);
            }   
            String row = sb.toString();
            if(set.contains(row)) return;
            set.add(row);
        }
        keys.add(list);
        answer++;
    }
}