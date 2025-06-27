import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] parent;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		parent = new int[n + 1];
		visited = new boolean[n + 1];
		
		for(int i = 0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}
		
		// 양방향 그래프
		for(int i =0; i < n- 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr.get(x).add(y);
			arr.get(y).add(x);
		}
		
		dfs(1);
		for(int i = 2; i < parent.length; i++) {
			System.out.println(parent[i]);
		}

	}

	// 부모 노드 찾기
	private static void dfs(int node) {
		visited[node] = true;
		for(int val : arr.get(node)) {
			if(!visited[val]) {
				dfs(val);
				parent[val] = node;
				
			}
		}
		
	}

}
