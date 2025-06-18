import java.io.*;
import java.util.*;

public class Main {
	
	static int ran = 100_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		if(n == k) {
			System.out.println(0);
			return;
		}
		boolean[] visited = new boolean[ran + 1];
		Queue<Integer> que = new LinkedList<>();
		que.offer(n);
		visited[n] = true;
		int count = 0;
		int size = 0;
		while(true) {
			count++;
			size = que.size();
			for(int i = 0; i < size; i++) {
				int x = que.poll();
				visited[x] = true;
				if(x + 1 == k || x - 1 == k || x * 2 == k) {
					System.out.println(count);
					return;
				}
				if(x - 1 >= 0 && !visited[x -1]) {
					visited[x-1] = true;
					que.offer(x -1);
				}
				if(x + 1 <= ran && !visited[x + 1]) {
					visited[x+1] = true;
					que.offer(x + 1);
				}
				if( x * 2 <= ran && !visited[x * 2]) {
					visited[x * 2] = true;
					que.offer(x * 2);
				}
			}
		}

	}

}
