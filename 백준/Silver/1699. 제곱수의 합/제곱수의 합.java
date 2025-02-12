import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// dp[] 선언
		int[] dp = new int[n + 1];
		
		// dp[n 구하기.
		for(int i = 1; i <= n; i++) {
			dp[i] = i;
			//System.out.println("초기값 확인: " + dp[i]);
			for(int j = 2; j * j <= i; j++) {
				if(dp[i] > dp[i - j * j] + 1) {
					dp[i] = dp[i - j * j] + 1;
					//System.out.println("dp 갱신 확인: " + dp[i]);
				}
			}
		}
		System.out.println(dp[n]);

	}

}
