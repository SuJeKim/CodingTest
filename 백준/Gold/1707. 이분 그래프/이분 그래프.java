import java.io.*;
import java.util.*;

public class Main {
	
	static int v, e;
	static int[] visited;
	static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		while(k --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[v + 1];
			visited = new int[v + 1];
			
			for(int i = 1; i<= v; i++) {
				graph[i] = new ArrayList<>();
			}
			
			// 간선 입력
			for(int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graph[b].add(a);
			}
			
			//이분 그래프 판단 변수
			boolean isBipartite = true;
				
			// 모든 정점에서 탐색.
			for(int i = 1; i <= v; i++) {
				if(visited[i] == 0) {
					// dfs 탐색에서 이분 그래프가 아니다 => false
					// 이분 그래프 판단 변수 false + break.
					if(!dfs(i, 1)) {
						isBipartite = false;
						break;
					}
				}
			}
			System.out.println(isBipartite ? "YES" : "NO");
			
		}

		
		
	}

	/**
	 * 이분 탐색 그래프인지 확인하는 함수
	 * @param cur 현재 노드
	 * @param color 노드의 색 1 , -1 둘 중 하나 (default : 1)
	 * @return 내부 탐색 중 인접한 노드의 색이 같을 경우 false 리턴
	 * 주의 해야 할 점은 하위 호출에서 false 리턴 시 상위 호출에서도 false @return.
	 */
	private static boolean dfs(int cur, int color) {
		
		visited[cur] = color;
		for(int next : graph[cur]) {
			if(visited[next] == 0) { 
				//System.out.println("next 색 : " + next + "현 노드 색 : " + cur);
				if(!dfs(next, -color)) {
					return false;
				}
			}else if(visited[next] == color) {
				return false;
			}
		}
		
		return true;
	}

}
