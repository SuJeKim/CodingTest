import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(t --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			int answer = -1;
			int gcd = getGcd(m,n);
			int lcm = (m * n) / gcd;
			
			for(int i = x; i <= lcm; i+=m) {
				if(i % n == y) {
					answer = i + 1;
					break;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	// 최대공약수
	private static int getGcd(int m, int n) {
		if(n == 0) return m;
		return getGcd(n, m % n);
	}

}
