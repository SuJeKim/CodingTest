import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// DP 배열 선언
		int[] dp = new int[1001];
		
		// dp 초기값 설정
		dp[1] = 1;
		dp[2] = 2;
		
		// dp 구하는 코드
		// i = 46~, int형 범위(10자리)를 넘음
		// 최종 % 10007을 나누는 것이 아닌 중간 과정에서 나누어야 함.
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
			//System.out.println("확인:" + dp[i] + "i의 값:" + i);
		}
		//System.out.println("최종 확인:" + dp[n]);
		System.out.println(dp[n]);
				

	}

}
