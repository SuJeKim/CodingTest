import java.io.*;
import java.util.*;

public class Main {
	
	static int n,k;
	static boolean[] visited;
	static int max = 100_000;
	static int min = Integer.MAX_VALUE; // time과 비교

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new boolean[max + 1];
		
		bfs();
	}

	private static class Node {
		int now;
		int time;
		
		private Node(int now, int time) {
			this.now = now;
			this.time = time;
		}
	}
	
	private static void bfs() {
		Deque<Node> que = new LinkedList<>();
		que.offer(new Node(n,0));
		visited[n] = true;
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			//System.out.println("방문처리 전:" + cur.now + " , " + cur.time);
			if(cur.now == k) {
				int result = Math.min(min, cur.time);
				System.out.println(result);
				return;
			}
			if(cur.now * 2 <= max && !visited[cur.now * 2]) {
				que.offerFirst(new Node(cur.now * 2, cur.time));
				visited[cur.now * 2] =true;
			}
			if(cur.now - 1 >= 0&& !visited[cur.now - 1]) {
				que.offerLast(new Node(cur.now - 1, cur.time + 1));
				visited[cur.now - 1] =true;
			}
			if(cur.now + 1 <= max && !visited[cur.now + 1]) {
				que.offerLast(new Node(cur.now + 1, cur.time + 1));
				visited[cur.now + 1] =true;
			}
		}
		
		
	}

}
