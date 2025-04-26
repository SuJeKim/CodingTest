import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] map;
	static boolean[] visited;
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(min);

	}

	/**
	 * 팀 조합 생성
	 * @param depth 각 팀의 구성
	 * @param start 중복 불가.
	 */
	private static void dfs(int depth, int start) {
		if(depth == n/2) {
			// visited = true/ false로 팀 나눔.
			diff();
			return;
		}
		// visited[]로 팀 빌딩하기 때문에 방문 처리 재귀 호출만 하면 됨.
		for(int i = start; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	/**
	 * 각 팀의 능력치 차이 갱신
	 * 팀 빌딩: visited false, true 설정.
	 * 조건이 차이값이 0 이면 출력 및 종료.
	 * 전역변수 활용
	 */
	private static void diff() {
		// 각 팀 이름 선언.
		// start - true, link - false
		int start = 0;
		int link = 0;
		
		// 팀 빌딩
		for(int i = 0; i<n-1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(visited[i] == true && visited[j] == true) {
					//System.out.println(i+ " " + j);
					start += map[i][j];
					start += map[j][i];
					//System.out.println("true 팀 : " + start + " ");
				}
				else if(visited[i] == false && visited[j] == false) {
					//System.out.println(i+ " " + j);
					link += map[i][j];
					link += map[j][i];
					//System.out.println("flase 팀: "+ link + " ");
				}
			}
		}
		int val = Math.abs(start - link);
		
		// 문제 조건에서 차이값의 최소는 0.
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		min = Math.min(val, min);
	}

}
