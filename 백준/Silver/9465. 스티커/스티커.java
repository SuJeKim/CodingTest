import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			int n = Integer.parseInt(br.readLine());
			
			// 스티커 비용 저장
			int[][] cost = new int[2][n+1];
			// 최댓값 dp
			int[][] dp = new int[2][n+1];
			
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j <= n; j++) {
					cost[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 초기값 설정
			dp[0][1] = cost[0][1];
			dp[1][1] = cost[1][1];
			
			for(int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + cost[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + cost[1][i];
			}
			int result = Math.max(dp[0][n], dp[1][n]);
			sb.append(result).append("\n");
			
		}
		System.out.println(sb);

	}

}
