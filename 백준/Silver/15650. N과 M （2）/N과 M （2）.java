import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		
		dfs(1,0);
		System.out.println(sb);
	}

	private static void dfs(int loc, int depth) {
		
		if(depth == m) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i = loc; i <= n; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);
		}
		
	}

}
