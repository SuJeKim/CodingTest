import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int mod = 1_000_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n+1][k+1];
		
		Arrays.fill(dp[0], 1);
		for(int i = 0; i <= n; i++) {
			dp[i][1] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 2; j <= k; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				dp[i][j] %= mod;
			}
		}
		System.out.println(dp[n][k]);
	}

}
