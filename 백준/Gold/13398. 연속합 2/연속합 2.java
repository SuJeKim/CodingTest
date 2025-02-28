import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[][] dp = new int[n][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i =0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 초기값 저장 및 result 선언 및 초기화
		dp[0][0] = dp[0][1] = arr[0];
		int result = arr[0];
		
		/**
		 * dp[i][0]: 제거 안 한 경우
		 * dp[i][1]: 제거 한 경우
		 */
		for(int i = 1; i <n; i++) {
			dp[i][0] = Math.max(arr[i], dp[i-1][0] + arr[i]);
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + arr[i]);
			result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
		}
		System.out.println(result);

	}

}
