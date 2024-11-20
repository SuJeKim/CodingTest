import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<Integer>();
		int value = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			switch(order) {
			case "push" :
				value = Integer.parseInt(st.nextToken());
				que.offer(value);
				break;
			case "pop" :
				if(que.isEmpty()) sb.append(-1).append("\n");
				else sb.append(que.remove()).append("\n");
				break;
			case "size" :
				sb.append(que.size()).append("\n");
				break;
			case "empty" :
				if(que.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front" :
				if(que.isEmpty()) sb.append(-1).append("\n");
				else sb.append(que.peek()).append("\n");
				break;
			case "back" :
				if(que.isEmpty()) sb.append(-1).append("\n");
				else sb.append(value).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
	
}