import java.io.*;
import java.util.*;

public class Main {

	static int n, k;
	static int[] time, moveRoute;
	static int maxVaule = 100_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		time = new int[maxVaule + 1];
		moveRoute = new int[maxVaule + 1];
		
		if(n == k) {
			System.out.println(0);
			System.out.println(n);
			return;
		} 
		bfs(n,k);
		System.out.println(time[k] - 1);
		
		Stack<Integer> stack = new Stack<>();
		stack.push(k);
		int index = k;
		while(index != n) {
			stack.push(moveRoute[index]);
			index = moveRoute[index];
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);

	}

	private static void bfs(int start, int end) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		time[start] = 1;
		
		while(!que.isEmpty()) {
			Integer now = que.poll();
			
			if(now == end) return;
			
			if(now * 2 <= maxVaule && time[now * 2] == 0) {
				time[now * 2] = time[now] + 1;
				moveRoute[now * 2] = now;
				que.offer(now * 2);
			}
			
			if(now + 1 <= maxVaule && time[now + 1] == 0) {
				time[now + 1] = time[now] + 1;
				moveRoute[now + 1] = now;
				que.offer(now + 1);
			}
			
			if(now - 1 >= 0 && time[now - 1] == 0) {
				time[now - 1] = time[now] + 1;
				moveRoute[now - 1] = now;
				que.offer(now - 1);
			}
			
		}
		
	}

}
