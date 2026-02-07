import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        HashMap<String,Integer> answerMap = new LinkedHashMap<>();
        for(String i : id_list){
            answerMap.put(i,0);
        }

        HashMap<String,Integer> reportedMap = new HashMap<>();
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        Set<String> seen = new HashSet<>();
        for(String re : report){

            String reporter = re.split(" ")[0];
            String reported = re.split(" ")[1];
             if (!seen.add(re)) {
                continue;
            }

            map.putIfAbsent(reported, new ArrayList<>());
            map.get(reported).add(reporter);



            reportedMap.put(reported,reportedMap.getOrDefault(reported,0) + 1);

        }

        for(Map.Entry<String,Integer> entry : reportedMap.entrySet()){
            int count = entry.getValue();
            String name = entry.getKey();
            if(count >=k){
                ArrayList<String> aa = map.get(name);
                for(String w: aa){
                    answerMap.put(w,answerMap.getOrDefault(w,0) +1);
                }
            }
        }

        ArrayList<Integer> value  = new ArrayList<>(answerMap.values());

        return value.stream().mapToInt(Integer::intValue).toArray();



    }
}