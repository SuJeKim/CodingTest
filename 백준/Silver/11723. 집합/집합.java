import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int m = Integer.parseInt(br.readLine());
		int s = 0;
		while(m --> 0) {
			st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			int num = 0;
			
			switch (str) {
			case "add" : 
				num = Integer.parseInt(st.nextToken()) - 1;
				s |= (1 << num);
				break;
			case "remove" :
				num = Integer.parseInt(st.nextToken()) - 1;
				s &= ~(1 << num);
				break;
			case "check" :
				num = Integer.parseInt(st.nextToken()) - 1;
				int val = s & (1 <<num);
				sb.append(((val == 0) ? 0 : 1) + "\n");
				break;
			case "toggle" :
				num = Integer.parseInt(st.nextToken()) - 1;
				s ^= (1 << num);
				break;
			case "all" :
				s = (1 << 21) -1;
				break;
			case "empty" :
				s = 0;
				break;
			}
			
		}
		System.out.println(sb);
	}

}
