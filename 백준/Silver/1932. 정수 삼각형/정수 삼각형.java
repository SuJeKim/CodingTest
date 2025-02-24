import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static Integer[][] dp;
	private static int[][] triangle;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new Integer[n][n];
		triangle = new int[n][n];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기값
		for(int i = 0; i < n; i++) {
			dp[n-1][i] = triangle[n-1][i];
		}
		
		System.out.println(find(0,0));

	}

	// dp 재귀 함수
	private static int find(int depth, int idx) {
		// 마지막 행일 경우 현재 위치의 idx 반환.
		if(depth == n-1) return dp[depth][idx];
		
		// 탐색하지 않은 행일 경우 다음 행의 양쪽 값 중 최댓값 비교
		if(dp[depth][idx] == null) {
			dp[depth][idx] = Math.max(find(depth+1, idx), find(depth +1, idx+1)) + triangle[depth][idx];
			//System.out.println("확인: " + dp[depth][idx]);
		}
		return dp[depth][idx];
	}

}
