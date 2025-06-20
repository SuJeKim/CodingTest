import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(br.readLine());
		
		bfs(s);

	}

	private static class Node {
		int total; // 지금 이모티콘 개수
		int copy; // 클립보드
		int time; // 출력값
		
		 Node(int total, int copy, int time) {
			this.total = total;
			this.copy = copy;
			this.time = time;
		}
	}
	
	private static void bfs(int s) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(1, 0, 0));
		
		// [copy][total]
		boolean[][] visited = new boolean[1001][1001];
		visited[0][1] = true;
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			
			if(cur.total == s) {
				System.out.println(cur.time);
				return;
			}
			
			// 각 조건들 탐색
			// 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
			que.offer(new Node(cur.total, cur.total, cur.time + 1));
			
			// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다
			// 클리보드 비어있지 않고 방문하지 않고 copy + total <= s
			if(cur.copy != 0 && cur.total + cur.copy <= s && !visited[cur.copy][cur.total + cur.copy]) {
				que.offer(new Node(cur.total + cur.copy, cur.copy, cur.time + 1));
				visited[cur.copy][cur.total + cur.copy] = true;
			}
			
			// 3. 화면에 있는 이모티콘 중 하나를 삭제
			// total >= 1 && 방문하지 않음.
			if(cur.total >= 1 && !visited[cur.copy][cur.total -1]) {
				que.offer(new Node(cur.total - 1, cur.copy, cur.time + 1));
				visited[cur.copy][cur.total - 1] = true;
			}
			
		}
	}
	
	

}
