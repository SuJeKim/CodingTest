import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수강 가능 인원(K), 대기목록의 길이(L)
        int k = Integer.parseInt(st.nextToken()); 
        int l = Integer.parseInt(st.nextToken()); 

        // <학번, 대기목록의 순서>
        Map<String, Integer> map = new HashMap<>();

        // 대기목록 저장
        // 학번을 key로, 대기순서(i)를 value로 HashMap에 저장
        for (int i = 0; i < l; i++) {
            String s = br.readLine(); // 학번 입력
            map.put(s, i); 
        }

        // 학번을 대기순서에 따라 배열에 저장
        String[] arr = new String[l];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            arr[entry.getValue()] = entry.getKey();
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            if (arr[i] != null) {
                sb.append(arr[i] + "\n");
                k--; // 수강 가능 인원을 하나씩 감소시킴
            }
            if (k == 0) break; 
        }
        System.out.println(sb);
    }
}