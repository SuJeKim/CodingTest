import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1, 1, 0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j<m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		System.out.println(bfs(0,0));
		
	}
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cnt;
		
		Node(int x, int y, int cnt){
			this.x = x;
			this.y = y; 
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cnt - o.cnt;
		}
	}

	private static int bfs(int x, int y) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		boolean[][] visited = new boolean[n][m];
		
		visited[y][x] = true;
		que.offer(new Node(x, y, 0));
		
		while(!que.isEmpty()) {
			Node no = que.poll();
			int curX = no.x;
			int curY = no.y;
			
			if(curX == m -1 && curY == n-1) {
				return no.cnt;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx < 0 || ny < 0 || ny >= n || nx >= m) continue;
				
				if(!visited[ny][nx] && map[ny][nx] == 0) {
					visited[ny][nx] = true;
					que.offer(new Node(nx, ny, no.cnt));
				}
				
				if(!visited[ny][nx] && map[ny][nx] == 1) {
					visited[ny][nx] = true;
					que.offer(new Node(nx, ny, no.cnt + 1));
				}
			}
		}
		
		return 0;
	}

}
