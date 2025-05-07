import java.io.*;
import java.util.*;

public class Main {

	static int n, s, result;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		if(s == 0) {
			result--;
		}
		System.out.println(result);
	}

	private static void dfs(int depth, int sumVal) {
		if(depth == n) {
			if(s == sumVal) {
				result++;
			}
			return;
		}
		
		 // 원소 선택 시 합계
		dfs(depth + 1, sumVal + arr[depth]);
		
		// 원소 선택 안 할 때  합계
		dfs(depth + 1, sumVal);
	}

}
