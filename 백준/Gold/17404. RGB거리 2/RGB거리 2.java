import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[n+1][3];
		int[][] dp = new int[n+1][3];
		int result = Integer.MAX_VALUE;
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int c = 0; c < 3; c++) {
			// 첫번째 짐 설정.
			for(int i = 0; i < 3; i++) {
				if(i == c) {
					dp[1][i] = cost[1][i];
				}else {
					dp[1][i] = 1_000 * 1_000;
				}
			}
			// 2 ~ n까지 나머지 색상 정하기
			for(int i = 2; i <= n; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
			}
			
			// 최솟값 정하기 단, 처음 집 색이랑 마지막 집 색이 달라야 함.
			for(int i = 0; i < 3; i++) {
				if(i != c) {
					result = Math.min(result, dp[n][i]);
				}
			}
		}
		System.out.println(result);
	}

}
