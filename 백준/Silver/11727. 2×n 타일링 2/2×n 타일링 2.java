import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// dp 배열 선언
		int[] dp = new int[1001];
		
		// 초기값 설정
		dp[1] = 1;
		dp[2] = 3;
		
		//dp_Bottom_up
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1]+ (dp[i-2] * 2)) % 10007;
			//System.out.println("확인:" + dp[i] + " i의 값:" + i);
		}
		System.out.println(dp[n]);

	}

}
