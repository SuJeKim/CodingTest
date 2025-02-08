import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배열 크기 입력 및 LIS 크기 구하는 dp[], arr[] 선언
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		int[] arr = new int[n];
		
		// arr[] 초기화
		StringTokenizer st =new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// LIS 크기 구하는 dp[]
		int lis = 0;
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			lis = Math.max(lis, dp[i]);
			//System.out.println("lis 확인: " + lis);
		}
		// 출력 값 sb에 저장
		StringBuilder sb = new StringBuilder();
		sb.append(lis + "\n");
		
		// 부분 수열 stack 저장
		Stack<Integer> store = new Stack<Integer>();
		for(int i = n - 1; i >= 0; i--) {
			if(dp[i] == lis) {
				store.push(arr[i]);
				lis--;
			}
		}
		// 부분 수열 sb에 저장.
		while(!store.empty()) {
			sb.append(store.pop() + " ");
		}
		System.out.println(sb.toString());
	}

}
