import java.util.*;
import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] p = new int[N+1];
		int[] m = new int[N+1];
		
		int mincount = 0;
		int maxcount = 0;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			String b = st.nextToken();
			int c = Integer.parseInt(st.nextToken());
			
			if(b.equals("P")){
				if(c == 1) {
					p[a] = 1;
				}
				else {
					p[a] = -1;
				}
			}
			else {
				if(c == 0) {
					m[a] = 1;
				}
				else {
					m[a] = -1;
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(p[i] != -1 && m[i] != -1) {
				maxcount++;
				if(p[i] == 1 && m[i] == 1) {
					mincount++;
				}
			}
		}
		
		bw.write(mincount+" "+maxcount);
		
		br.close();
		bw.close();
	}
}