import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static Queue<Integer> inputArr = new LinkedList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		StringTokenizer st;
		
		// 그래프 입력.
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i =0; i < n -1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		// 방문 순서 입력.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			inputArr.add(Integer.parseInt(st.nextToken()));
		}
		
		//peek() == 1인지 확인.
		int top = inputArr.poll();
		if(top != 1) {
			System.out.println("0");
		}else {
			System.out.println(dfs(1,0) ? 1 : 0);
		}
		

	}

	// 방문 순서가 맞는지 확인.
	private static boolean dfs(int nod, int parent) {
		if(visited[nod]) {
			return true;
		}
		visited[nod] = true;
		
		// 인접한 정점 hashSet에 저장.
		HashSet<Integer> check = new HashSet<>();
		for(int next : graph.get(nod)) {
			if(next != parent) {
				check.add(next);
			}
		}
		
		// 방문 순서와 값 비교 및 dfs 재귀 호출
		while(!check.isEmpty()) {
			int val = inputArr.poll();
			if(check.contains(val)) {
				check.remove(val);
				dfs(val, nod);
			}else {
				return false;
			}
		}
		
		return true;
	}

}
