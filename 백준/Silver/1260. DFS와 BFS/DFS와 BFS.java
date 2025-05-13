import java.io.*;
import java.util.*;

public class Main {

	static int n,m,v;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		// 간선 입력
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 무방향 그래프이므로 양방향 추가
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i = 0; i < n+1; i++) {
			Collections.sort(graph[i]);
		}
		
		// dfs
		visited = new boolean[n + 1];
		dfs(v);
		System.out.println();
		
		// bfs
		visited = new boolean[n + 1];
		bfs(v);
		
	}
	
	private static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		
		for(int next : graph[start]) {
			if(!visited[next]) {
				//System.out.println("DFS 이동: " + start + " -> " + next);
				dfs(next);
			}
		}
		
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			start = queue.poll();
			System.out.print(start + " ");
			
			for(int next : graph[start]) {
				if(!visited[next]){
					visited[next] = true;
					//System.out.println("BFS 이동: " + start + " -> " + next);
					queue.offer(next);
				}
			}
		}
		
		
	}


}
