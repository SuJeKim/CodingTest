import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] heard = new String[N];
        String[] seen = new String[M];
        
        for (int i = 0; i < N; i++) {
            heard[i] = br.readLine();
        }
        
        for (int i = 0; i < M; i++) {
            seen[i] = br.readLine();
        }
        
        Arrays.sort(heard);
        Arrays.sort(seen);
        
        List<String> result = new ArrayList<>();
        
        for (String name : heard) {
            if (Arrays.binarySearch(seen, name) >= 0) {
                result.add(name);
            }
        }
        
        Collections.sort(result);
        bw.write(result.size() + "\n");
        for (String name : result) {
            bw.write(name + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
