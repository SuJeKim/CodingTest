import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static boolean check = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 사람 수(정점)
		n = Integer.parseInt(st.nextToken());
		// 친구 관계(간선)
		m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n];
		graph = new ArrayList[n];

		// 정점의 인접 리스트를 초기화
		for(int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		// 간선(친구 관계) 입력
		for(int i = 0; i< m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		/*for (int i = 0; i < n; i++) {
		    System.out.print("노드 " + i + "의 인접 노드들: ");
		    for (int next : graph[i]) {
		        System.out.print(next + " ");
		    }
		    System.out.println();
		}*/
		
		// 모든 정점에서 dfs 시작
		for(int i = 0; i < n; i++) {
			dfs(i , 0);
			if(check) break;
		}
		System.out.println(check ? 1 : 0);
	}

	private static void dfs(int node, int depth) {
		// 5개 이상의 노드 방문 시
		if(depth == 4) {
			check = true;
			return;
		}
		visited[node] = true;
		for(int next : graph[node]) {
			if(!visited[next]) {
				dfs(next, depth + 1);
				// 상위 호출들 종료 -> 경로 하나만 찾아도 됨.
				if(check) return;
			}
		}
		visited[node] = false;
	}

}
