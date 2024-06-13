import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용해 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 N과 M을 읽어옴
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        // 수열을 저장할 배열 생성
        int[] sequence = new int[M];
        
        // 백트래킹 함수 호출
        solve(N, M, 0, 1, sequence);
    }

   
    public static void solve(int N, int M, int depth, int start, int[] sequence) {
        // 현재 수열의 길이가 M이면 수열을 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }
        
        // start부터 N까지의 숫자를 선택
        for (int i = start; i <= N; i++) {
            sequence[depth] = i;  // 수열에 숫자 추가
            solve(N, M, depth + 1, i, sequence);  // 재귀 호출, i를 start로 전달하여 비내림차순 유지
        }
    }
}
