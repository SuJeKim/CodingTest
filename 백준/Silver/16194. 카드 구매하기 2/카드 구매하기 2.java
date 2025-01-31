import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dp = new int[1001];
	static int[] p = new int[10001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 카드 개수
		int n = Integer.parseInt(br.readLine());
		
		// 각 카드 가격
		String prices = br.readLine();
		StringTokenizer st= new StringTokenizer(prices);
		for(int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		// 최솟값 구하기
		for(int i = 1; i <=n; i++) {
			// 초기값 설정
			dp[i] = p[i];
			for(int j = 1; j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j] + p[j]);
				// System.out.println("확인:" + dp[i]);
			}
		}
		System.out.println(dp[n]);

	}

}
