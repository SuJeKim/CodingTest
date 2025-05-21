import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	static int count = Integer.MIN_VALUE;
	static int[][] map;
	static Queue<int[]> que = new LinkedList<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0; i< n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					que.offer(new int[] {i,j});
					//System.out.println(i + " " + j);
				}
			}
		}
		System.out.println(bfs());

	}

	private static int bfs() {
		
		// 그래프 탐색
		while(!que.isEmpty()) {
			int[] val = que.poll();
			int curX = val[0];
			int curY = val[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if(map[nx][ny] == 0) {
						map[nx][ny] = map[curX][curY]  + 1;
						que.offer(new int[] {nx,ny});
					}
				}
			}
		}
		
		// 문제 조건에 따라 리턴.
		for(int i = 0; i < n; i++) {
			for(int j = 0; j< m; j++) {
				if(map[i][j] == 0) {
					return -1;
				}
				count = Integer.max(count, map[i][j]);
			}
		}
		return count == 1 ? 0 : count - 1;
	}

}
