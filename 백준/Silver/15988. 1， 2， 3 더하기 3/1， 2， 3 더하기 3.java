import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static final int MOD = 1000000009;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// dp[] 선언 및 초기화
		long[] dp = new long[1_000_001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i <= 1_000_000; i++) {
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
		}
		
		int t = Integer.parseInt(br.readLine());
		while(t --> 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
			
		}
		
	}

}
