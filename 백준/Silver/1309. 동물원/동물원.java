import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		final int mod = 9901;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		/**
		 * dp[n+1][3] 선언
		 * i = i번쨰 열, j = 우리에 넣는 경우의 수
		 * 0 = 배치 안함, 1 = 첫번째 칸, 2 = 둘째 칸
		 */
		int[][] dp = new int[n+1][3];
		dp[1][0] = dp[1][1] = dp[1][2] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
		}
		
		int answer = (dp[n][0] + dp[n][1] + dp[n][2]) % mod;
		System.out.println(answer);

	}

}
