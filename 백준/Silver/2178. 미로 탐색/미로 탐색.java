import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx =  {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		System.out.println(bfs(0,0));
	}

	private static int bfs(int x, int y) {
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int curX = now[0];
			int curY = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						que.add(new int[] {nx, ny});
						visited[nx][ny] = true;
						map[nx][ny] = map[curX][curY] + 1;
					}
				}
			}
		}
		
		
		return map[n-1][m-1];
	}

}
