import java.util.*;

class Solution {
    static HashMap<Integer, ArrayList<String>> answer = new HashMap<>();
    static HashMap<Integer, Integer> max = new HashMap<>();
    static List<HashSet<String>> orderList = new ArrayList<>();
    static String [] info;    
    static int max_length = 1;
    
    public String[] solution(String[] orders, int[] course) {
       
        for(int i = 0; i < course.length; i++){
           ArrayList<String> temp = new ArrayList<>();
           answer.put(course[i], temp);
           max.put(course[i], 2); 
           max_length = Math.max(max_length, course[i]); 
        }
        
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < orders.length; i++){
            HashSet<String> temp = new HashSet<>();
            for(int j = 0; j < orders[i].length(); j++){
                String cur = Character.toString(orders[i].charAt(j));
                set.add(cur);
                temp.add(cur);
            }
            orderList.add(temp);
        }
        
        info = new String [set.size()];
        Iterator<String> it = set.iterator();
        int idx = 0;
        while(it.hasNext()){
            info[idx++] = it.next();
        }
        // 백트래킹  
        func(0, "");
        
        ArrayList<String> newOrders = new ArrayList<>();
        for(int i = 0; i < course.length; i++){
            for(int j = 0; j < answer.get(course[i]).size(); j++){
                newOrders.add(answer.get(course[i]).get(j));
            }
        }
        Collections.sort(newOrders);
        String [] returnOrder = new String [newOrders.size()];
        for(int i = 0; i < newOrders.size(); i++){
            returnOrder[i] = newOrders.get(i);
        }
        return returnOrder;    
    }
    public static void func(int depth, String cur){
        if(depth == info.length || max_length == cur.length()){
            return;
        }
        String temp = cur + info[depth];
        if(max.containsKey(temp.length())){
            int cnt = 0;
            for(int i = 0; i < orderList.size(); i++){
                boolean flag = true;
                for(int j = 0; j < temp.length(); j++){
                    if(!orderList.get(i).contains(Character.toString(temp.charAt(j)))){
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
            if(max.get(temp.length()) < cnt){ // 갱신 
                max.put(temp.length(), cnt);
                answer.get(temp.length()).clear(); 
                answer.get(temp.length()).add(temp);
            }
            else if(max.get(temp.length()) == cnt){ 
                answer.get(temp.length()).add(temp); 
            }
        }
        func(depth + 1, temp);    
        func(depth + 1, cur);
    }
}