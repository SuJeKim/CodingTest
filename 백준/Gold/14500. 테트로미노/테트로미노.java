import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int max = Integer.MIN_VALUE;
	
	// 읿력값 저장
	static int[][] arr;
	
	// 방문 확인
	static boolean[][] visit;
	
	static int n;
	static int m;
	
	// 상하좌우 탐색
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0, 0 , -1, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 전체 탐색
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visit[i][j] = true;
				dfs(i,j,arr[i][j],1);
				visit[i][j] = false;
			}
		}
		System.out.println(max);
	}

	/*
	 * row,col : 현재 탐색중인 좌표, 
	 * sum: 현재까지 합한 값, 
	 * count: 현재까지 칸 개수
	 */
	private static void dfs(int row, int col, int sum, int count) {
		
		// 테트르미노 칸의 수는 4개 => 종료
		if(count == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		// 상하좌우 탐색
		for(int i = 0; i < 4; i++) {
			int curRow = row + dx[i];
			int curCol = col + dy[i];
			
			// 범위 확인
			if(curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
				continue;
			}
			
			// ‘ㅗ’ 테트리미노 처리
			if(!visit[curRow][curCol]) {
				// 두 번째 칸에서 현재 위치에서 한 번 더 탐색.
				if(count == 2) {
					visit[curRow][curCol] = true;
					dfs(row,col,sum + arr[curRow][curCol], count + 1);
					visit[curRow][curCol] = false;
				}
				visit[curRow][curCol] = true;
				dfs(curRow,curCol,sum + arr[curRow][curCol], count + 1);
				visit[curRow][curCol] = false;
			}
		}
		
	}

}
