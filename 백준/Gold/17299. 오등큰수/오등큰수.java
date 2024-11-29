import java.io.*;
import java.util.*;

public class Main {

		static final int MAX = 1_000_001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        int[] cnt = new int[MAX];
        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        /*
        * data의 요소들의 Count 채움.
        * 예) data[0] = 1, cnt[1] = 1 // data[1] = 1, cnt[1] = 2.
        */
        for(int i = 0; i<N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            cnt[data[i]]++;
        }

        // 횟수비교 위해 data의 인덱스를 stack에 저장.
        /*
        * stack.peek => 해당 인덱스의 count 확인 vs 현 data 원소의 count확인.
        * 클 경우 => stack.peek값 비교 끝났으니 pop  
        */
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<N; i++){
            while(!stack.isEmpty() && cnt[data[stack.peek()]]<cnt[data[i]]){
                answer[stack.pop()] = data[i];
            }

            stack.add(i);
        }

        while(!stack.isEmpty())
            answer[stack.pop()] = -1;

        for(int i = 0; i<N; i++)
            sb.append(answer[i]).append(" ");

        System.out.println(sb);
    }
}