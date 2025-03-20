import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visit = new boolean[n];
		
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		
		// depth == m이면 탐색 종료 및 출력.
		if(depth == m) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		// 방문하지 않은 노드에 한하여 재귀 호출.
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(depth+1); // 다음 자식 노드 방문			
				visit[i] = false;
			}
				
		}
		
	}

}
