import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배열 크기 입력
		int n = Integer.parseInt(br.readLine());
		
		// arr[](문제), dp[](최장 길이 저장)
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		// 원소 arr에 할당
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[] 구하기.
		for(int i = 0; i < n; i++) {
			// 모든 dp[]값들의 최솟값은 1
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				// j번째 원소가 i번째 원소보다 작고 dp[i] < dp[j]+1 경우
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			// System.out.println(dp[i]);
		}
		
		// 값들이 할당되 dp[]에서 최장 길이 구하기
		int max = 0;
		for(int i =0; i < n; i++) {
			max = dp[i] > max ? dp[i] : max;
		}
		System.out.println(max);

	}

}
