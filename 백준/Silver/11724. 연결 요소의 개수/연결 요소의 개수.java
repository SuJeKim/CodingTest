import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		// 간선 입력
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		// 모든 정점 탐색
		int count = 0;
		for(int i = 1; i<=n; i++) {
			if(!visited[i]) {
				bfs(i);
				count++;
			}
		}
		System.out.println(count);
		
	}

	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int val = que.poll();
			
			for(int next : graph[val]) {
				if(!visited[next]) {
					visited[next] = true;
					que.offer(next);
				}
			}
		}
		
	}

}
