import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] arr;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visited = new boolean[n];
		
		StringTokenizer st = null;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(result);

	}

	private static void dfs(int depth, int start) {
		if(depth == n / 2) {
			diff();
			return;
		}
		for(int i = start; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(depth + 1, i + 1);
				visited[i] = false;
			}
		}
		
	}

	private static void diff() {
		int start = 0;
		int link = 0;
		
		for(int i = 0; i < n -1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(visited[i] == true && visited[j] == true
						) {
					start += arr[i][j];
					start += arr[j][i];
				}else if(visited[i] == false && 
						visited[j] == false) {
					link += arr[i][j];
					link += arr[j][i];
				}
			}
		}
		int val = Math.abs(start - link);
		if(val == 0) {
			System.out.println(0);
			System.exit(0);
		}
		result = Math.min(result, val);
	}

}
