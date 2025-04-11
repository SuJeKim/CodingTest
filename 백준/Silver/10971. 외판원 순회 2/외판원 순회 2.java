import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int result = Integer.MAX_VALUE;
	static int[][] w;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader( new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 미리 시작 시점 고정
		visited[0] = true;
		dfs(0,0,0,0);
		System.out.println(result);
		

	}

	/**
	 * 
	 * @param start : 실행 전 Main에서 시작 시점 고정
	 * @param now : 현재 내 위치
	 * @param depth
	 * @param cost : 현재 도시까지의 비용.
	 */
	private static void dfs(int start, int now, int depth, int cost) {
		// 실행하기 전에 이미 방문했기에 n -1
		if(depth == n - 1 && w[now][start] != 0) {
			cost += w[now][start];
			result = Math.min(result, cost);
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!visited[i] && w[now][i] != 0) {
				visited[i] = true;
				dfs(start, i, depth + 1, cost + w[now][i]);
				visited[i]= false;
			}
		}
		
	}

}
