import java.util.Scanner;

public class Main {
	
	static final long mod = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// dp[][] 배열 선언
		// 자릿수(n)와 자릿값(0~9)
		long[][] dp = new long[n+1][10];
		
		// 자릿수 1인 경우 자릿값 초기화
		// 단,  0으로 시작하는 수는 계단수가 아니다.
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		// 2번째 자릿수부터 자릿값(j) 탐색.
		// 자릿값의 범위는 0~9, 자릿수의 범위는 2 ~ n
		// 오버플로우 안 나게 각 dp값에 % mod하기.
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <10; j++) {
				
				// j==0일 경우, i-1의 자릿값은 1만 가능.
				if(j == 0) {
					dp[i][0] = dp[i-1][1] % mod;
				}
				// j==9일 경우, i-1의 자릿값은 8만 가능.
				else if(j == 9) {
					dp[i][9] = dp[i-1][8] % mod;
				}
				// 그 외(2~7)자릿값들은 이전 자릿수의 자릿값 +1/ -1의 합
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
				}
			}
		}
		// n의 각 자릿값마다의 경우의 수의 함을 출력.
		long result = 0;
		for(int i =0; i < 10; i++) {
			result += dp[n][i];
		}
		System.out.println(result % mod);

	}

}
