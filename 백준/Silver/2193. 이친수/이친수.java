import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// dp[] 선언 및 초기화
		long[] dp = new long[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		// dp[n] 구하는 로직.
		// 점화식: dp{n] = dp[n-1] + dp[n-2]
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n]);

	}

}
