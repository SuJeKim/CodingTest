import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수열 크기 입력받기
		int n = Integer.parseInt(br.readLine());
		
		// arr[n], dp[n] 선언.
		long[] arr = new long[n];
		long[] dp = new long[n];
		
		// arr[n] 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[0] 초기화, maxSum 초기화
		dp[0] = arr[0];
		long maxSum = arr[0];
		
		// dp[] 구하기 및 maxSum 갱신 주의 i = 1
		for(int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			//System.out.println("dp 확인: " + dp[i]);
			maxSum = Math.max(maxSum, dp[i]); 
			//System.out.println("결과값 갱신 확인: " + maxSum);
		}
		System.out.println(maxSum);
		
	}

}
