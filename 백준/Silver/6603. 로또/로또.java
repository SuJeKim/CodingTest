import java.io.*;
import java.util.*;

public class Main {

	static int k, arr[], result[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			result = new int[6];
			
			if(k == 0) {
				break;
			}
			
			for(int i =0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			sb.append("\n");
		}
		System.out.print(sb);

	}

	private static void dfs(int depth, int start) {
		if(depth == 6) {
			for(int val : result) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i < k; i++) {
			result[depth] = arr[i];
			dfs(depth + 1, i + 1);
		}
		
	}

}
