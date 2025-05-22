import java.io.*;
import java.util.*;

public class Main {

	static int l;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			l = Integer.parseInt(br.readLine());
			graph = new int[l][l];
			visited = new boolean[l][l];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			bfs(startX, startY);
			System.out.println(graph[endX][endY]);
			
		}

	}

	private static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			for(int i = 0; i < 8; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if(nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
					visited[nx][ny] = true;
					graph[nx][ny] = graph[curX][curY] + 1;
					que.offer(new int[] {nx, ny});
				}
			}
		}
		
		
	}

}
