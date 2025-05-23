import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static char[][] graph;
	static boolean[][] visited;
	static boolean hasCycle = false;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0 , 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m =  Integer.parseInt(st.nextToken());
		graph = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j <m; j++) {
				graph[i][j] = str.charAt(j);
			}
		}
		
		// dfs
		for(int i = 0; i <n; i++) {
			for(int j = 0; j < m; j++) {
				//색이 다른 경우도 확인해야 함.
				visited = new boolean[n][m];
				dfs(i, j, -1, -1, graph[i][j], 1);
				if(hasCycle) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");
	}

	/**
	 * 
	 * @param x 현재 x 좌표
	 * @param y 현재 y 좌표
	 * @param fromX 직전 x 좌표
	 * @param fromY 직전 y 좌표
	 * @param color 색 비교
	 * @param depth 깊이가 4이상일 때까지 재귀.
	 */
	private static void dfs(int x, int y, int fromX, int fromY, char color, int depth){
		if(visited[x][y]) {
			if(depth >= 4) {
				hasCycle = true;
				return;	
			}
		}
		visited[x][y] = true;
		
		for(int i = 0; i <4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			if (nx == fromX && ny == fromY) continue;
			if(graph[nx][ny] == color) {
				//System.out.printf("이동: (%d, %d) → (%d, %d)%n", x, y, nx, ny);
				dfs(nx, ny, x, y, color, depth + 1);
			}
		}
		
	}

}
