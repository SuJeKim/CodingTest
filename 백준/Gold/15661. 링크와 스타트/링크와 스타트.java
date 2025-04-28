import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int teamNumber = 0;
	static int[][] map;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i < n; i++) {
			teamNumber = i;
			dfs(0,0);
		}
		System.out.println(result);

	}

	private static void dfs(int depth, int start) {
		if(depth == teamNumber) {
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
		int link = 0;
		int start = 0;
		for(int i = 0; i < n-1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(visited[i] == true && visited[j] == true) {
					link += map[i][j];
					link += map[j][i];
				}
				else if(visited[i] == false && visited[j] == false) {
					start += map[i][j];
					start += map[j][i];
				}
			}
		}
		int val = Math.abs(start - link);
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		result = Math.min(result, val);
		
	}

}
