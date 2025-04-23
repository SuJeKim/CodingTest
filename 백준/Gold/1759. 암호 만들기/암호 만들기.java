import java.io.*;
import java.util.*;

public class Main {

	static int L,C;
	static char[] arr,code;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken());
		
		// 입력값 저장 배열
		arr = new char[C];
		// 출력할 배열
		code = new char[L];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		dfs(0,0);
		System.out.println(sb);
	}

	private static void dfs(int depth, int start) {
		if(depth == L) {
			if(check(code)) {
				for(char val : code) {
					sb.append(val);
				}
				sb.append("\n");
			}
			return;
		}
		for(int i = start; i < C; i++) {
			code[depth] = arr[i];
			dfs(depth + 1, i + 1);
		}
		
	}

	// 모음 한개, 자음 2개 구성 확인하는 함수
	private static boolean check(char[] code) {
		int vo = 0; // 모음 개수
		int co = 0; // 자음 개수
		
		for(char ch : code) {
			if(ch == 'a' || ch == 'i' || ch == 'o' || ch == 'e' ||
					ch == 'u') {
				vo++;
			}else {
				co++;
			}
		}
		if(vo >= 1 && co >= 2) {
			return true;
		}else {
			return false;
		}
	}

}
