import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] result;
	static char[][] s;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		result = new int[n];
		s = new char[n][n];
		
		String str = br.readLine();
		int index = 0;
		for(int i =0; i<n; i++) {
			for(int j = i; j<n; j++) {
				s[i][j] = str.charAt(index++);
				//System.out.println(i + " " + j + " " +s[i][j]);
			}
		}
		dfs(0);
	}

	private static void dfs(int depth) {
		if(depth == n) {
			for(int val : result) {
				sb.append(val).append(" ");
			}
			System.out.println(sb);
			System.exit(0);
		}
		for(int i = -10; i <= 10; i++) {
			result[depth] = i;
			if(check(depth)) {
				dfs(depth + 1);
			}
		}
		
	}

	private static boolean check(int depth) {
		int val = 0;
		for(int i = 0; i < depth + 1; i++) {
			val += result[i];
		}
		for(int i = 0; i < depth + 1; i++) {
			if((val > 0 && s[i][depth] != '+') 
					||(val < 0 && s[i][depth] != '-')
					|| (val == 0 && s[i][depth] != '0')) {
				return false;
			}
			val -= result[i];
		}
		return true;
	}

}
