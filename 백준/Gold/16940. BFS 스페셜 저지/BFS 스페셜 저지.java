import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static boolean[] visited;
	static int[] inputList;
	static ArrayList<Integer>[] graph;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		visited = new boolean[n + 1];
		
		graph = new ArrayList[n + 1];
		for(int i = 0; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 양방향 간선 입력
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		// 입력값 방문 순서
		inputList = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			inputList[i] = Integer.parseInt(st.nextToken());
		}
		
		if(inputList[0] != 1) {
			System.out.println(0);
			return;
		}
		
		// 순서 확인 및 출력.
		System.out.println(checkBFS() ? 1 : 0);
	}

	// bfs 방문순서가 맞는지 확인하는 함수
	private static boolean checkBFS() {
		Queue<Integer> que = new LinkedList<>();
		int start = 1;
		visited[start] = true;
		que.offer(start);
		
		// 0번 인덱스 즉, 노드 1이 아니라 하위 노드부터 검사해야 함. 그래서 
		// 1번 인덱스로 초기화
		int inputIndex = 1;
		
		while(!que.isEmpty()) {
			start = que.poll(); // 다음 노드
			int childCount = 0;
			
			// graph에서 하위노드 방문처리 및 개수 저장.
			for(int val : graph[start]) {
				if(!visited[val]) {
					visited[val] = true;
					childCount++;
				}
			}
			
			// 입력 배열 순서와 하위노드의 인덱스가 맞는지 확인.
			for(int i = inputIndex; i < inputIndex + childCount; i++) {
				if(!visited[inputList[i]]) {
					// false 처리가 되어 있음 -> inputList[i]가 하위노드가 아님.
					return false;
				}else {
					que.offer(inputList[i]);
				}
			}
			// 1이 아닌 그 다음에 상위노드의 하위노드를 찾아야 하니 그 다음 인덱스 저장.
			inputIndex += childCount;	
		}
		return true;
	}

}
