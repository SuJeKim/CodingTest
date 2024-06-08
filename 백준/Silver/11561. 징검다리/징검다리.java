import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(bf.readLine());
        ArrayList<Long> results = new ArrayList<>(); // 결과를 저장할 리스트 생성

        for(int i = 0; i < T; i++){
            long N = Long.parseLong(bf.readLine());
            long start = 0;
            long last = (long) Math.sqrt((2 * N - 1));
            long result = 0;
            while(start <= last){
                long mid = (start + last) / 2;
                long sum = (mid) * (mid + 1) / 2;
                if(sum <= N){
                    result = Math.max(mid, result);
                    start = mid + 1;
                }
                else{
                    last = mid - 1;
                }
            }
            results.add(result); // 결과를 리스트에 추가
        }

        for (Long result : results) {
            System.out.println(result); // 결과를 한 번에 출력
        }
    }
}
