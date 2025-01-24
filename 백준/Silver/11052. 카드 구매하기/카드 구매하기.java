import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 금액 최댓값 저장할 배열
	static int[] dp = new int[1001];
	// 가격 저장할 배열
	static int[] p = new int[1001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 구매할 카드 개수 N
		int n = Integer.parseInt(br.readLine());
		
		// 가격 입력
		String prices = br.readLine();
		StringTokenizer st = new StringTokenizer(prices);
		for(int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		// 최댓값 구하기
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + p[j]);
			}
		}
		System.out.println(dp[n]);	
	}

}
