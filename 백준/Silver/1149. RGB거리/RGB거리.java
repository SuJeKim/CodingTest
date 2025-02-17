import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int Red = 0;
	private static int Green = 1;
	private static int Blue = 2;
	
	private static int[][] cost;
	private static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// dp,cost 이차원 비열 선언.
		cost = new int[n][3];
		dp = new int[n][3];
		
		// cost[][] 입력값 저장.
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			cost[i][Red] = Integer.parseInt(st.nextToken());
			cost[i][Green] = Integer.parseInt(st.nextToken());
			cost[i][Blue] = Integer.parseInt(st.nextToken());
		}
		
		// dp의 첫째 집들의 각 색 비용들로 초기화 -> 초기값 설정
		dp[0][Red] = cost[0][Red];
		dp[0][Green] = cost[0][Green];
		dp[0][Blue] = cost[0][Blue];
		
		System.out.println(Math.min(paint(n-1, Red), Math.min(paint(n-1, Green), paint(n-1, Blue))));

	}
	
	// 최소의 비용 구하는 재귀함수 
	static int paint(int n, int color) {
		
		// 탐색 안 했으면
		if(dp[n][color] == 0) {
			
			// 각 색 선택 별로 cost 점화식을 dp[n][R], dp[n][G], dp[n][B]에 저장
			if(color == Red) {
				dp[n][Red] = Math.min(paint(n-1, Green), paint(n-1, Blue)) + cost[n][Red];
			} else if(color == Green) {
				dp[n][Green] = Math.min(paint(n-1, Red), paint(n-1, Blue)) + cost[n][Green];
			} else {
				dp[n][Blue] = Math.min(paint(n-1, Red), paint(n-1, Green)) + cost[n][Blue];
			}
		}
		
		return dp[n][color];
	}

}
