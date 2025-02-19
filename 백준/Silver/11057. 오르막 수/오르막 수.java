import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final int mod = 10_007;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n + 1][10];
		
		// 초기값 설정.
		for(int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}
		
		/**
		 * 점화식:  dp[i][j]  += dp[i-1][k]
		 * 자리 수 만큼 반복(1 ≤ i < N), 
		 * 가능한 수 반복( 0 ≤ j ≤ 9), 
		 * i자리 수의 j값의 경우의 수 반복(j ≤ k ≤ 9)
		 */
		for(int i = 1; i < n + 1; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					dp[i][j]  += dp[i-1][k];
					dp[i][j] %= mod;
				}
			}
		}
		System.out.println(dp[n][0] % mod);

	}

}
