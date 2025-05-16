import java.io.*;
import java.util.*;

public class Main {

	static int n, count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0 , -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j <n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		// 모든 집 탐방
		// 방문하지 않고 집이 있을 경우(1)
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i <n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					count = 0;
					dfs(i,j);
					result.add(count);
				}
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(int val : result) {
			System.out.println(val);
		}
		

	}

	// 상하좌우 탐색
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		count++;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i]; // 다음 행 위치
			int ny = y + dy[i];// 다음 열 위치
			
			//배열 범위 내에 있고, 방문하지 않았고 집이 있는 경우에만 탐색.
			if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
		
	}

}
