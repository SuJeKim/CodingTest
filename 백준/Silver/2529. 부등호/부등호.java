import java.io.*;
import java.util.*;

public class Main {

	static int k;
	static char[] arr;
	static boolean[] visited= new boolean[10];
	static ArrayList<String> result = new ArrayList<String>();
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		arr = new char[k];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i =0; i < k; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		for(int i = 0; i<10; i++) {
			visited[i] = true;
			dfs(i,0,i+""); 
			visited[i] = false;
		}
		System.out.println(result.get(result.size() - 1)); // 최댓값
		System.out.println(result.get(0)); // 최솟값

	}
	/**
	 * dfs: 각 부틍호에 해당하는 수(char) 구하기
	 * @param now 현재값
	 * @param count 깊이 탐색
	 * @param numberArr 누적 문자열
	 */
	private static void dfs(int now, int count, String numberArr) {
		if(count == k) {
			result.add(numberArr);
			return;
		}
		for(int next = 0; next < 10; next++) {
			if(!visited[next]) {
				if((arr[count] == '>' && now > next) || 
						(arr[count] == '<' && now < next)) {
					visited[next] = true;
					dfs(next, count + 1, numberArr + next);
					//System.out.println(numberArr);
					visited[next] = false;
				}
			}
		}
	}

}
